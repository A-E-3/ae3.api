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

## Desktop launch has eleven call sites and no opt-in carrier in the tree (measured 2026-11-20)

Superseded: this section said eleven sites. The count is thirteen, and the corrected measurement is in `Desktop launch has thirteen call sites and no opt-in carrier in the tree (corrected 2026-11-20)` below. This heading could not be renamed, since `--magic-section-upsert` cannot rename one.

## Desktop launch has thirteen call sites and no opt-in carrier in the tree (corrected 2026-11-20)

`Engine.createProcess` at `/Volumes/workspace/myx/ae3.api/java/ru/myx/ae3/Engine.java:274` opens a file through the desktop's default handler. Every call site therefore opens one window on whichever machine runs it. The guard ruled 2026-11-20 is the key `ru.myx.ae3.properties.desktop.launch`, read in the static block where the `optimize` property is read at `:149`. `MODE_SIZE` is declared at `:56` and assigned one line lower, at `:150`, and an absent value refuses.

**The key is in 0 code and config files of this place, and in the two prose files that document it.** `grep -rl 'ru\.myx\.ae3\.properties\.desktop\.launch'` over `/Volumes/workspace/myx` returns 0 files for `.java`, `.xml`, `.sh`, `.launch`, `.json` and `.js` each, and 0 in `.txt`, `.properties`, `.tpl`, `.html` and `.jslt`. A `.md` sweep returns 2 files: this one and `ae3.sys.pkg.l2.tgt.html/MAGIC.md`. The same probe for `ru\.myx\.ae3\.properties\.optimize` returns 1 file, `Engine.java` itself, so the instrument reads. The shipped jar agrees: `acm-cvs/sys-current/axiom/ru.myx.ae3api-5.0.jar`'s `Engine.class` holds `createProcess` and that optimize key once each, and the launch key 0 times. The devel copy at `/Users/myx/Workspaces/ws-myx.ae3-devel/source/ae3/ae3.api/java/ru/myx/ae3/Engine.java` holds 0 occurrences of `DESKTOP_LAUNCH` too, so a fix here reaches that tree only when the owner pulls it.

**Thirteen sites call it, in thirteen files across eleven projects.** Two instruments agree on the count. `grep -rn 'Engine\.createProcess' --include='*.java'` over the whole place returns 13 lines, against 179 files for the control `Engine.createGuid` and 19491 `.java` files searched. The earlier count of eleven came from the same grep over each project's `java/` folder plus `myx-meloscopesong/src`, which returns 10 plus that one.

| project | site |
|---|---|
| `ae3.sdk` | `/Volumes/workspace/myx/ae3.sdk/java/ru/myx/ae3/l2/folder/TestFolderServeRequest.java:37` |
| `ae3.sdk` | `/Volumes/workspace/myx/ae3.sdk/java/ru/myx/ae3/serve/file/ServeRequestExecuteFileOnReply.java:42` |
| `ae3.sdk` | `/Volumes/workspace/myx/ae3.sdk/java/ru/myx/ae3/serve/folder/ServeRequestReplyToTestFolder.java:39` |
| `ae3.system` | `/Volumes/workspace/myx/ae3.system/java/ru/myx/ae3/system/Static.java:122` |
| `ae3.sys.pkg.l2.tgt.swt` | `/Volumes/workspace/myx/ae3.sys.pkg.l2.tgt.swt/java/ru/myx/ae3/l2/swt/SwtTargetContext.java:161` |
| `ae3.sys.pkg.l2.tgt.html` | `/Volumes/workspace/myx/ae3.sys.pkg.l2.tgt.html/java/ru/myx/ae3/l2/html/test/TestHtml.java:66` |
| `ae3.sys.pkg.l2.tgt.dhtml` | `/Volumes/workspace/myx/ae3.sys.pkg.l2.tgt.dhtml/java/ru/myx/ae3/l2/dhtml/test/TestDhtml.java:62` |
| `ae3.sys.pkg.l2.tgt.xml` | `/Volumes/workspace/myx/ae3.sys.pkg.l2.tgt.xml/java/ru/myx/ae3/l2/xml/TestXml.java:33` |
| `ae3.sys.pkg.l2.tgt.xls` | `/Volumes/workspace/myx/ae3.sys.pkg.l2.tgt.xls/java/ru/myx/ae3/l2/xls/TestXls.java:33` |
| `ae3.sys.pkg.l2.tgt.text` | `/Volumes/workspace/myx/ae3.sys.pkg.l2.tgt.text/java/ru/myx/ae3/l2/text/TestText.java:32` |
| `ae3.test` | `/Volumes/workspace/myx/ae3.test/test/ru/myx/ae3/l2/pdf/test/TestPdf.java:75` |
| `myx-meloscopesong` | `/Volumes/workspace/myx/myx-meloscopesong/src/meloscopesong/Generator.java:137` |
| `unit-test` | `/Volumes/workspace/myx/unit-test/src/ae3run/iface/telnet/RunTelnet.java:38` |

**Both misses are source folders a `.classpath` names but `java/` is not.** `ae3.test/.classpath:5` declares `path="test"`, where `TestPdf` sits, and `unit-test/.classpath:3` declares `path="src"`, where `RunTelnet` sits. So a grep bounded by the folder name `java/` is bounded by a convention, not by where a project compiles from.

**A seventh render entry, and the only site that reads the return value.** `TestPdf.java:75` is a render entry, inside the `else` of `if (Engine.createRandom( 2 ) == 1)` at `:53`, so about one run in two opens a PDF. `RunTelnet.java:41` to `:43` is the one site of the thirteen that branches on the returned `Process`: `if (process == null) { throw new RuntimeException( "Cannot start!" ); }`. The other twelve discard it.

**No entry can opt in today, by either route.** A `System.setProperty` line is one route and a `-D` in a launcher the other. The tree holds neither for this key.

- `TestHtml.java:33-36` and `TestDhtml.java:32-35` each set four properties before their first `Engine` touch, at `:37` and `:36`. The setter order is already right there, and neither sets the launch key.
- `TestXml.java:21`, `TestXls.java:21`, `TestText.java:20` and `Generator.java:137` set no property before reaching `Engine`.
- `TestPdf.java:25` reaches `Engine` through `TestAe3.initAE3()`. Its own four `setProperty` lines at
  `:34` to `:37` sit inside the dead `if (false) {` block that opens at `:26` and closes at `:43`.
- `TestAe3.initAE3()` sets seven properties at `:45` to `:64` before its first `Engine` touch at `:66`.
  66 files call it across `ae3.test` (32), `unit-test` (33) and `ae3.sys.pkg.l2.tgt.awt`'s
  `TestAwt.java:17`, and the whole place gives 67, the extra being `TestE4Parse.java:22`. A second
  66-set differs from this one by one member at each end: it drops `TestAe3.java` and keeps
  `TestE4Parse.java`. Both are 66, so a check that returns 66 has not settled which set it read. Only two of
  the thirteen launch sites are among them: `TestPdf.java:25` and
  `RunTelnet.java:25`. `TestAwt.java:17` calls it too, and `TestAwt` opens its window through
  `AwtTargetContext.doFinish()` and never through `createProcess`. So a line there reaches one render
  entry, not a block of them, and `RunTelnet` needs no carrier at all, since it already branches on a
  null return at `:41` to `:43`. The build chooses between that and a line in `TestPdf`'s own `main()`
  ahead of `:25`; both reach that entry alone.
- Six of the seven render-entry projects hold no `.launch`, `.bat` or `.sh` of their own, where `find` over each returns 0. The seventh, `ae3.test`, holds 14: ten `.launch` and four `.sh`. Eight of the ten are four non-render tests, each present twice: `TestEcma`, `TestReflect`, `TestS4` and `TestVfs`, in `bin/` and in `java/`. The other two are `TestPdf` itself, once in `bin/` and once in `test/`.

**One entry has a launcher on disk, and its project is under no version control.** `/Volumes/workspace/myx/ae3.test/test/ru/myx/ae3/l2/pdf/test/TestPdf.launch` sits in the source folder `ae3.test/.classpath:5` names and reads `VM_ARGUMENTS` as `-ea` with no `ru.myx.ae3.properties` key of any kind. Two more copies carry the same md5 `ff272f7b473f0e53f09347ccbc0e1de3`: `/Volumes/workspace/myx/ae3.test/bin/ru/myx/ae3/l2/pdf/test/TestPdf.launch`, and `/Volumes/workspace/myx/ae3-share/ae3-distro/common/ae3-classes/ru/myx/ae3/l2/pdf/test/TestPdf.launch`, which is a build output. The `.metadata` folder holds two more, and they differ. So the place holds five copies, and three of them are byte-identical.

- `TestPdf.launch` is md5 `fa694f2570d1ccbf6eb48cd5793d88e3` and reads `VM_ARGUMENTS` as `-ea`. It maps to `/ae3.sys.l2.tgt.pdf/src/ru/myx/ae3/l2/pdf/test/TestPdf.java`, a project that is not on disk.
- `TestPdf (1).launch` is md5 `dc8bad0af31f00d40b5b10792593d43f` and carries no `VM_ARGUMENTS` attribute at all. It maps to `/ae3.test/test/ru/myx/ae3/l2/pdf/test/TestPdf.java`, the file that exists.

`MAKE-AE3-DISTRO.xml:85` stages `<fileset dir="../ae3.test/bin" />` into `${distro}/common/ae3-classes/`, and `:12` sets `distro` to `../ae3-share/ae3-distro`. So the third tree copy is that build's own output, not a hand-placed duplicate. The `test` folder is not staged; the `bin` copy carries the same bytes to that path. The `<tar>` at `:88` to `:92` packs the result, and `/Volumes/workspace/myx/ae3-share/ae3-distro/common/ae3-classes.tbz`, md5 `adf521e393de2a09583d78529c606dca`, holds five `.launch` entries, `TestPdf` among them beside the four non-render tests. A `-D` added to the `bin` copy therefore reaches `ae3-classes` and the tarball on the next build, where the `test` and `.metadata` copies reach neither.

So the one `.metadata` config whose mapping is right is also the one with nothing to add a `-D` to. `ae3.test` holds no `.git`, so that launcher is a file on disk and not a versioned one, and it shares the version status of the configs below. The tree copies' `MAPPED_RESOURCE_PATHS` entry is stale: it reads `/ae3.test/src/ru/myx/ae3/l2/pdf.test/TestPdf.java`, and `ae3.test` has no `src` folder and no `pdf.test` package. Its `MAIN_TYPE` is right, `ru.myx.ae3.l2.pdf.test.TestPdf`, so the config still launches.

**The Eclipse configs sit outside every project, and they carry nothing for these entries.** `/Volumes/workspace/myx/.metadata/.plugins/org.eclipse.debug.core/.launches` holds 258 `.launch` files at its top level, and 259 below it. Exactly one names each of `ru.myx.ae3.l2.xml.TestXml`, `ru.myx.ae3.l2.text.TestText`, `ru.myx.ae3.l2.html.test.TestHtml`, `ru.myx.ae3.l2.dhtml.test.TestDhtml` and `meloscopesong.Generator`, and none names `ru.myx.ae3.l2.xls.TestXls`.

- All five of those configs hold 0 `ru.myx.ae3.properties` VM arguments. `VM_ARGUMENTS` reads `-ea` in `TestHtml.launch` and `Generator.launch`, and is absent in `TestXml (1).launch`, `TestText.launch` and `TestDhtml.launch`.
- The place holds three `TestXml` configs and only one names the render entry. `TestXml (1).launch` names `ru.myx.ae3.l2.xml.TestXml` and carries no `VM_ARGUMENTS`. `TestXml.launch` names `ae3test.xml.TestXml`, which has no source file anywhere in the place, and `TestXml (2).launch` names `ru.myx.ae3.test.xml.TestXml` at `/Volumes/workspace/myx/ae3.test/java/ru/myx/ae3/test/xml/TestXml.java`. Both of those read `-ea`, and neither reaches a render entry.
- Three of the place's 258 top-level configs do carry such an argument: `TestEcmaImplScripts.launch`, `TestTpl.launch` and `UTIL-AcmTools-ShellAE3.launch`. So the carrier works, and no render entry uses it.
- `.metadata` is under no version control. `git -C /Volumes/workspace/myx/.metadata rev-parse --is-inside-work-tree` reports no repository, and the place root `/Volumes/workspace/myx` holds no `.git` either. Its 58 project checkouts do, so a file's version status is a fact about its own project, never about the place.

So the `System.setProperty` line is the one carrier available to all seven entries. A `-D` in a launcher reaches `TestPdf` alone, and only through a `.metadata` config that carries no `VM_ARGUMENTS` today. That route both adds a line and lands in a folder no checkout carries.

**Six of the seven render entries never call `initAE3`, so a line inside it cannot opt them in.** Measured 2026-11-24 from 13:29 to 13:48 +0200.

- `TestAe3` occurs 0 times in each of these six files: `TestXml.java`, `TestXls.java`, `TestText.java`, `TestHtml.java`, `TestDhtml.java` and `Generator.java`. Each of the six calls `Engine.createProcess`, at `:33`, `:33`, `:32`, `:66`, `:62` and `:137`.
- None of the six `.classpath` files names `/ae3.test`, the project `initAE3` lives in. The same search finds it in `ae3.test.pkg.e4/.classpath` and `unit-test/.classpath`, so the probe reads a known positive.
- No shipped invocation of a shared runner names them, though the runner would carry one. `SuiteLauncher.java:31` calls `initAE3()` before its `:33` reflects on the class it is handed. The four wrapper scripts take their classpath from every `*/bin` under the place, 108 directories at depth 1, so each entry class is reachable. Five of the six render-entry projects hold their own entry under `bin/`. `ae3.sys.pkg.l2.tgt.pdf` holds no `TestPdf.class`; that copy sits in `ae3.test/bin`, and `Generator.class` sits in `myx-meloscopesong/bin`. All seven entry classes carry a `public static void main`. No wrapper passes one: the four scripts carry four `SuiteLauncher` command lines, and they name 24 suites, `TestVfs`, `TestS4` and 22 `ru.myx.ae3.test.*` names, 14 in `ae3-basic.test.sh` and 8 in `ae3-core.test.sh`. `SuiteLauncher` occurs in 0 of the 258 top-level `.launch` configs and 0 below them, where the control `TestAe3` occurs in 2. Their fully qualified names occur in 0 files of `ae3.test`'s four source folders, where the control `TestS4` occurs in 2. A bare-name `TestXml` probe over those folders returns 5 files and 11 lines. Four files and nine lines sit in `ru/myx/ae3/test/xml/`. The fifth is `TestAe3.java`'s `import` at `:31` and its `:120` call, both reaching `ru.myx.ae3.test.xml.TestXml`, not the render entry `ru.myx.ae3.l2.xml.TestXml`.
- Two controls hold the reach fact itself. `TestPdf.java:25` calls `initAE3` and is the one render entry the carrier reaches. `TestAwt.java:17` calls it while its `.classpath` names only `ae3.api` and `ae3.sdk`, so a missing project entry alone does not prove a call impossible.

So a line in `initAE3` reaches `TestPdf` alone among the seven entries. The other six opt in, if at all, through a `System.setProperty` line of their own. The six others need a line of their own, or a recorded decision that their launch is meant to stop.

**Two of the thirteen are person-facing, and neither is reached by default on this machine.** Both were measured against source on 2026-11-21 from 00:10 to 00:40 +0200.

- `ae3.sys.pkg.l2.tgt.swt`'s `/Volumes/workspace/myx/ae3.sys.pkg.l2.tgt.swt/java/ru/myx/ae3/l2/swt/SwtTargetContext.java:161` opens a link when a person clicks it, inside `setLink` at `:156`. One line in the whole place constructs that class: `TestSwt.java:26`, in the same project. The project holds no `ae3-packages/` and no `settings/`, so no descriptor selects the target, and a grep for `SwtTargetContext` outside the project returns 4 files, all prose or Eclipse history rather than code: `ae3.api/MAGIC.md`, `ae3.sys.pkg.l2.tgt.html/MAGIC.md` and two refactoring-history files under `.metadata`. It ships in no jar either. 0 of the 51 jars under `acm-cvs/sys-current/axiom/` holds a `ru/myx/ae3/l2/swt/` entry, where `ru.myx.ae3sys.l2.tgt.text-5.0.jar` holds `ru/myx/ae3/l2/text/`. `ae3-devel-tools/MAKE-AE3-DISTRO.xml` names `l2.tgt.swt` 0 times, against 2 for `l2.tgt.text`. So the click site is reached by `TestSwt` alone, never by a server dispatch. Its one launcher is `.metadata`'s `TestSwt.launch`, md5 `7191336ffccf652ee67186c86cc63596`, which carries no `VM_ARGUMENTS`. On this host the class cannot initialise at all. `display` is the static field `Display.getDefault()` at `:68`, the pinned `/Volumes/workspace/myx/ae3-in/swt-cocoa-macosx-x86_64-3.5/swt.jar` holds three `x86_64` Mach-O bundles, and the machine is arm64. Its own `MAGIC.md:24` records the `UnsatisfiedLinkError` that follows, so the click never reaches the guard.
- `ae3.system`'s `/Volumes/workspace/myx/ae3.system/java/ru/myx/ae3/system/Static.java:122` is the body of `startUrl` at `:120`. Its only four callers are `Local.java:46`, `:53`, `:60` and `:67`, all inside `if (openTtys)` at `:41`, and `openTtys` is `System.getProperty("ae3.executable.local.open_ttys", "false").equals("true")` at `:40`. A grep of every text file under the place, `.git` and `incoming/` excluded, returns two for that key. They are `Local.java:40` and `ae3.system/README.md:28`, a sentence about it. No `.launch`, `.sh`, `.xml` or `.js` names it. `.metadata`'s `Local.launch`, md5 `4280368ac6674352ddbd79d865c14667`, carries `-Djava.net.preferIPv4Stack=true` alone. So the one config that launches this entry does not take the branch.

So both paths are already closed today. The SWT click site has no route except `TestSwt`, whose launcher sets nothing. The `ae3.system` site sits behind a property that no file in the place sets. A guard that refuses by default changes neither path's behaviour.

Reopening one takes a carrier, and there are two. One is a line in `TestSwt`. The other is a `-D` in `TestSwt.launch`. The first edits a project the Scope excludes, and the second edits a folder no checkout carries.

This is a source reading. The eleven-site table was taken 2026-11-20 from 09:30 to 09:50 +0200, and the count and both misses were re-measured at 11:20 to 11:37. Three line references and one setter count in this section were corrected at 13:35 to 13:51 +0200, against the same source files, and the shared-carrier bullet at 14:45 to 15:00 +0200 with its caller count and its reach. Two statements were corrected at 15:45 to 16:35 +0200: the sentence that said no render-entry project holds a launcher, and the `VM_ARGUMENTS` detail, which named two `-ea` configs where there are three. A third, the phrase `committed launcher`, was wrong about version control, since `ae3.test` holds no `.git`. Four statements were corrected at 21:25 to 22:15 +0200: the `-ea` attribution, which named `TestXml.launch` for a config that reaches no render entry, the caller count, which now states its bound, the stale mapping path of the `TestPdf` launcher, and the three `TestXml` configs. One statement was corrected at 23:55 to 00:05 +0200: the launcher population, which is 258 at the top level and 259 below it, the extra being `servlet/ru.myx.ae3.l2.servlet.AbstractHttpServlet.launch`, a server config rather than a Java launch. That number and the tables, setters and line references above were re-read against the same source at 23:44 to 00:05, and the place-wide control counts were not re-run. Three statements were corrected and two widened at 00:10 to 00:40 on 2026-11-21: the `ae3.test` launcher count now says ten `.launch` and four `.sh` of its 14, the `TestPdf` copies are four in all, two of them in `.metadata`, and the correctly mapped one carries no `VM_ARGUMENTS`, and the person-facing paragraph now states each site's route and its own launcher. No entry ran, no build was made and no window was opened. One statement was added at 13:29 to 13:48 +0200 on 2026-11-24: the reach of the `initAE3` carrier across the seven render entries, with its controls, which is the paragraph above the person-facing one. The five render-entry launches are recorded in `ae3.sys.pkg.l2.tgt.html/MAGIC.md`, section `Every render-target test entry opens its output on the desktop`. One sentence was bounded at 14:22 to 14:36 +0200 on 2026-11-24: the shared-runner claim now states what is shipped rather than what the runner could carry, and the class-name probe names its instrument. Two statements in the shared-runner bullet were corrected at 15:06 to 15:20 +0200 on 2026-11-24. The classpath sentence claimed the six projects' own `bin/` trees carry their entries, and one carries none. The bare-name count gave a file total for a population outside one package. One statement was corrected at 15:43 to 15:53 +0200 on 2026-11-24: the launcher inventory now names the third tree copy and where it comes from, since the place holds five copies and the section accounted for four. Two statements were bounded at 16:57 to 17:00 +0200 on 2026-11-24. One clause of that provenance said the `TestPdf` copies are four in all, where this section's own paragraph gives five. The key's absence now names code and config files, since two `MAGIC.md` files in the place carry the key.
