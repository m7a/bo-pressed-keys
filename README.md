---
section: 32
x-masysma-name: pressed_keys
title: Ma_Sys.ma Pressed Keys
date: 2020/01/12 22:16:18
lang: de-DE
author: ["Linux-Fan, Ma_Sys.ma (Ma_Sys.ma@web.de)"]
keywords: ["programs", "java", "pressedkeys"]
x-masysma-version: 1.0.0
x-masysma-repository: https://www.github.com/m7a/bo-pressed-keys
x-masysma-website: https://masysma.lima-city.de/32/pressed_keys.xhtml
x-masysma-owned: 1
x-masysma-copyright: |
  Copyright (c) 2014, 2020 Ma_Sys.ma.
  For further info send an e-mail to Ma_Sys.ma@web.de.
---
Beschreibung
============

Pressed Keys ist ein kleines, graphisches Java Programm, welches es ermöglicht,
festzustellen, wie viele Tastatureingaben maximal gleichzeitig an den Computer
übertragen werden. Die Anzahl der gleichzeitig drückbaren Tasten ist für manche
Computerspiele sehr wichtig und kann mit diesem Programm schnell und einfach
ermittelt werden.

![Pressed Keys mit mehreren gedrückten Tasten](pressed_keys_att/screenshot.png)

Bitte beachten: Das Programm ist von 2009, also schon etwas „alt“. Es erfüllt
seinen hauptsächlichen Zweck recht gut, bessere Programme für den selben Zweck
sind aber bei anderen „Anbietern“ verfügbar!

Inbetriebnahme
==============

Abhängigkeiten: Ant und ein JDK (bis Java 8 incl. getestet).

 1. Kompilieren mit `ant jar`
 2. Ausführen mit `java -jar pressed_keys.jar`

Ein Debian-Package `mdvl-pressed-keys` kann per `ant package` generiert werden,
wenn die benötigten Abhängigkeiten zum Erstellen von Debian Packages vorhanden
sind.
