# MAGIC.md — ae3.api

## For keeper-ae3 / magic-tester

`TransferDescription` (`java/ru/myx/ae3/binary/TransferDescription.java`) defines the traffic classes (`IDLE_UNLIMITED`, `DEFAULT_UNLIMITED`, the `PC_*` priorities). How they are applied to a socket and restored after a delayed reply is in `ae3.sys`'s own MAGIC.md.

## `ru.myx.ae3.e4.logic.LogicBuilder` is one name with two shapes, and this project holds the shape that ships wrong

`/Volumes/workspace/myx/ae3.api/java/ru/myx/ae3/e4/logic/LogicBuilder.java:8` is 10 lines: `public interface LogicBuilder extends LogicFactory`, empty body. Its three `constant*` methods come from `LogicFactory<V>` at `:12` of the same package.

`/Volumes/workspace/myx/ae3.sdk.e4/java/ru/myx/ae3/e4/logic/LogicBuilder.java:3` is 28 lines, `extends` nothing, and declares twelve `add*` methods from `:5` to `:27`.

**The launcher ships the other project's shape, by its own reading of `axiom/`. No JVM classpath order decides a class load.**

The owner's ruling governs the JVM half: classpath order picks no class, because a class loads when something asks for it. A service starts in its declared dependency order.

The launcher is a separate mechanism with its own measurement. Its `boot.LdLibs` constructor iterates a `TreeMap` keyed by library name (`/Volumes/workspace/myx/clean-boot/java/boot/LdLibs.java:22`, `:45`) and copies every entry into one shared map by `sourceGlobal.put` (`:67`), whose own `put` replaces an earlier entry with a later one (`/Volumes/workspace/myx/clean-boot/java/boot/SourceDirectAbstract.java:47`). This paragraph is the launcher's own reading, not the JVM's.

- `ru.myx.ae3api` sorts before `ru.myx.ae3sdk`, so that loader presents the sdk copy: 12 declared methods, extends nothing.
- This project's 165-byte copy is in `ru.myx.ae3api-5.0.jar`, so that loader never presents it. A JVM started with `-cp` does present it whenever the api jar comes first, measured at 0 declared methods, so the copy is reachable and the choice is the caller's.
- Renaming the api jar to `ru.myx.ae3zzzapi-5.0.jar` makes that loader present this project's copy, 0 declared methods and extends `LogicFactory`. That is the control separating name order from directory order. Measured over a two-jar folder and over the whole `axiom/` folder, JDK 25.0.2.
- `ae3-classes/` is not runtime input at all, so the timestamps that decide its contents (`MAKE-AE3-DISTRO.xml:33`) never reach a running JVM. `MAGIC.md` in `ae3-devel-tools` records that already.

**The implementors are written against one shape or the other, so no single copy is complete.**

| Implementor | Written against | Under this project's copy | Under the `ae3.sdk.e4` copy |
|---|---|---|---|
| `ae3.sdk`'s `MacroBuilder` | this shape, its three `constant*` | complete | `AbstractMethodError` on all twelve |
| `ae3.sdk`'s `JavaLogicBuilder` | this shape | cannot be built | cannot be built |
| `ae3.sdk.e4`'s `LogicBuilderSimple` | the twelve-`add*` shape | `AbstractMethodError` on `constantInteger` and `constantString` | complete |

- `MacroBuilder` declares `constantValue` at `:10`, `constantInteger` at `:17`, `constantString` at `:24`, and no `add*` method.
- `LogicBuilderSimple` declares twelve `add*` methods from `:11` and no `constant*` method.
- Only three files import the interface by name: `ae3.sdk`'s `JavaLogicBuilder` and `MacroBuilder`, and `ae3.sys.pkg.e4.vm-vliw32-3a-2010`'s `VmVliw32_3a`. `LogicBuilderSimple` sits in the same package as the `ae3.sdk.e4` copy, so it needs no import.
- So the rename is the repair that makes all three implementors buildable at once. Renaming the `ae3.sdk.e4` copy touches `LogicBuilder.java` and `LogicBuilderSimple.java` there, plus `LogicBlock.java:25` and `AbstractLogicBlock.java:24`, which take `LogicBuilderSimple` as a `compile` parameter.
- `JavaLogicBuilder` cannot be constructed today: its constructor throws `java.lang.Error: Unresolved compilation problem: The interface LogicFactory cannot be implemented more than once with different arguments`.
- That clash is this file's own fault and is eight characters wide. `extends LogicFactory<Object>` compiles, and then `JavaLogicBuilder` builds clean. Measured 2026-11-09 with `javac` 25.0.2, and it does not repair `LogicBuilderSimple`.
- `ae3.sdk/bin` holds no `LogicBuilder` at all. The twelve-method copy in `ru.myx.ae3sdk-5.0.jar` comes from `acm-devel-tools/EXPORT-MAKE-SYS-CURRENT.xml:42`, the `ae3.sdk.e4/bin` fileset, not line 41.

**This project's jar carries another project's classes, and one of them disagrees with the copy beside it.**

- `ru.myx.ae3api-5.0.jar` holds 2,884 entries, of which 44 are `ru/myx/util/` classes this project does not compile. They arrive from `acm-devel-tools/EXPORT-MAKE-SYS-CURRENT.xml:29`, the `clean-java.util/bin` fileset.
- `ru.myx.ae3sdk-5.0.jar` holds 1,485 entries, and 41 of its names also occur in the api jar. These belong to 21 types, and 37 of the 41 entries are byte-identical.
- Four differ: the three `ru/myx/ae3/e4` types above, plus `ru/myx/util/MapSetNullButRemove`. `clean-java.util`'s copy declares `remove(Object, Object)` beside `remove(Object)`, at 1,901 bytes against 1,605 for `ae3.sdk`'s.
- So a `ru.myx.util` duplicate reaches the shipped tree by the same route as `LogicBuilder`. The launcher presents the narrower `ae3.sdk` copy there too.
- The launcher turns 51 jars plus one zip in `axiom/` into 48 library names, of which 47 are jars. `LibraryChooserFilter.accept` (`/Volumes/workspace/myx/clean-boot/java/boot/LibraryChooserFilter.java:19-32`) splits a filename at its last `-` for the library name, so `commons-compress`, `h2` and `hsqldb` each collapse two versions into one. Measured by constructing that loader over `axiom/`: `lib_count: 48`, with `org.tukaani.xz_1.10.0.jar` skipped and `nls_charset12` counted.

## The storage tiers, and the union root a module name resolves against

Four storage roots stack into `/union`, so one module name can live in any of the four tiers.

- **The four roots are system properties with defaults, set in two places.** `ae3.api`'s `Engine.java:180`,
  `:184`, `:188` and `:192` read `ru.myx.ae3.properties.path.public`, `.protected`, `.private` and
  `.shared`. The defaults are the working directory for public, and `~/.ae3/{protected,private,shared}`
  for the other three. `clean-boot`'s `boot.Main` overrides them at `java/boot/Main.java:61-72`: public
  becomes the cwd and the other three become `~/acm.cm5/{protected,private,shared}`. `Engine` creates all
  four directories at `:212`.
- **`Storage` mounts each as a VFS root and stacks four into `/union`.** `Storage.java:82`, `:101`, `:121`
  and `:132` mount `/public`, `/protected`, `/private` and `/shared`. The stack at `:148-153` is
  `PRIVATE`, `SHARED`, `PROTECTED`, `PUBLIC`, in that order. `:155-159` builds `/union` from it through
  `ImplementStorage.createUnionRoot` (`ae3.sys/java/ru/myx/ae3/vfs/ImplementStorage.java:188`), and `:171`
  builds `UNION_LIB` as `UNION/resources/lib`.
- **A module root is `<tier>/resources/lib` in every tier.** `Storage.java:92`, `:113` and `:171` build
  `PUBLIC_LIB`, `PROTECTED_LIB` and `UNION_LIB` that way. One consumer is on disk:
  `ru.acmcms.internal/domain/domain-global.js:53-56` falls back to
  `Storage.UNION_LIB.relative(moduleName + ".js", null)` when no server-side resolver is offered.
- **So a local tree with only a public half cannot resolve a module a host keeps in shared.** A file at
  `%SHARED%/resources/lib/<module>` is reachable wherever nothing earlier in the stack shadows it.
- **A host-side example is recorded, not measured here.** `magic-devops` measured
  `/usr/local/ae3/shared/resources/lib/com.ndmsystems.ndss/wapi/NdssWebShare.js` on two hosts, outside
  `public`. The details are in `ae3.sys.pkg.i3.web/MAGIC.md`. No local tree carries a `shared/resources/lib`
  with that module, so it cannot be reproduced from this workspace.
