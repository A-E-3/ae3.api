# CLAUDE.md — ae3.api

AE3 API Package: the core interfaces (`BaseMessage`, `ServeRequest`, `ReplyAnswer`, `TargetInterface`, etc.) that the rest of AE3 implements against.

## Convention: headers are attributes, not a dedicated API

`ServeRequest` (`java/ru/myx/ae3/serve/ServeRequest.java`) extends `BaseMessage` and has no `getHeader(name)` method. Request/response metadata — including raw HTTP headers like `Accept`, `Accept-Charset`, `Cookie` — is carried through the ordinary attributes map (`getAttributes()`, inherited from `BaseMessage`), keyed by the literal header name. The javadoc on `toBinary()`/`toCharacter()` references `"Content-Type"`, `"Content-Charset"`, `"Accept-Charset"`, `"Accept-Type"` attributes this way. Confirmed by `ae3.sys.pkg.i3.web`'s `QueryHttp`, which passes the raw HTTP header map straight through as the request's attributes at construction.

## Resource access: everything goes through the VFS, not the classpath

`java/ru/myx/ae3/vfs/Storage.java` is a custom virtual filesystem — mount points `Storage.PUBLIC`, `Storage.PROTECTED`, `Storage.PRIVATE`, `Storage.SHARED`, `Storage.UNION`, each backed by `Entry`/`EntryContainer` objects, not `java.io.File` or `ClassLoader.getResource*`. `Storage.PUBLIC.relative("resources/skin/<name>", null)` is the established pattern for reaching skin/package resources (see `ru.myx.ae3.l2.skin.Skin` in `ae3.sdk`). Files that ship under a unit's `ae3-packages/<pkg>/resources/...` folder (built via the `ae3-packages` source-process, e.g. `ae3.sys.pkg.l2.tgt.xml`'s `skin-standard-xml`) are mounted into this VFS at runtime — they are **not** on the Java classpath, so `ClassLoader.getResourceAsStream(...)` will not find them. Binary content is read off an `Entry` via `entry.toBinary().getBinaryContent()` (see `Storage.copy()` for the pattern), matching the `TransferCopier`/`Transfer` binary APIs used elsewhere (e.g. `ae3.sys.pkg.l2.tgt.xml`'s `XmlFileTargetContext`).
