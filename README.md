7. Laborübungsaufgabe
=====================

#### Themen:
- kovariante Probleme
- mehrfaches dynamisches Binden

#### Termine:
- reguläre Abgabe: `15.12.2010, 13:45 Uhr`
- nachträgliche Abgabe: `22.12.2010, 13:45 Uhr`

#### Abgabeverzeichnis:
`Gruppe/Aufgabe7`

#### Programmaufruf:
    
    java Test

#### Grundlage:

- Skriptum bis Seite 135
- Schwerpunkt auf Abschnitt 3.4

## Aufgabe

### Welche Aufgabe zu lösen ist:

Entwickeln Sie einen Teil einer Anwendung zur Ermittlung aller mit einem Computer verbundenen Datenträger. Folgende Arten von Datenträgern müssen unterstützt werden:

- HD (= Hard Disk bzw. Festplatte) und SSD (= Solid State Disks),
- optische Speichermedien wie CD, DVD und BD (= BluRay Disc),
- Speicherkarten in den Formaten
    - CF I, CF II (= Compact Flash in verschiedenen Dicken)
    - SD, miniSD, microSD (= Secure Digital Memory Card in verschiedenen Größen)
    - MS (= Memory Stick).

Jeder Datenträger ist mit einem Namen versehen, und eine Liste der Namen der mit einem Computer (direkt oder über verschiedene Schnittstellen) verbundenen Datenträger ist durch Aufruf der Methode volumes im Computer zu ermitteln.
Datenträger der Art HD und SSD sind entweder direkt in den Computer oder in ein USB-Device fest eingebaut. USB-Devices können lose über USB-Ports mit dem Computer verbunden sein. Datenträger aller anderen Arten sind über spezielle Laufwerke oder Kartenleser lose mit dem Computer verbunden. Unter einer losen Verbindung versteht man dabei, dass durch Aufruf einer Methode insert in einem geeigneten Objekt jederzeit die Verbindung zwischen einem noch unverbundenen Speichermedium bzw. USB-Device und einer freien Schnittstelle (USB-Port, optisches Laufwerk oder Kartenleser) hergestellt und durch Aufruf von eject wieder getrennt werden kann.

Ein Computer enthält genauso wie ein USB-Device eine festgelegte (zur Laufzeit nicht änderbare) Menge an technischen Einrichtungen folgender Arten:

- fest eingebaute Datenträger (HD bzw. SSD, ohne Unterstützung für die Methoden insert und eject)
- Laufwerke, die je nach Unterart entweder 
    - nur CDs 
    - oder CDs und DVDs
    - oder alle Arten optischer Speichermedien
    aufnehmen können
- Kartenleser (= Slots) für die unterschiedlichen Speicherkarten-Formate, in die in der Regel nur Speicherkarten des entsprechenden Formats passen 
    Ausnahmen: 
    - CF I Karten passen in CF II Slots
    - miniSD und microSD Karten passen in SD Slots
    - microSD Karten passen in miniSD Slots
- USB-Ports.

Die Methode insert liefert einen Wahrheitswert zurück der besagt, ob der Aufbau der Verbindung möglich war.
Datenträger, Laufwerke, Kartenleser, USB-Ports, USB-Devices und Computer sollen jeweils als Objekte unterschiedlicher Typen dargestellt werden. Zur Unterscheidung zwischen verschiedenen Arten von Objekten soll nur die in jedem Objekt vorhandene dynamische Typinformation dienen.

Die Klasse Test soll wie üblich die wichtigsten Normal- und Grenzfälle überprüfen und die Ergebnisse in allgemein verständlicher Form darstellen. Dabei sind Instanzen aller in der Lösung vorkommenden Typen zu erzeugen, verschiedene Verbindungsversuche anzustellen (auch solche, wo keine Verbindung herstellbar ist) und zur Kontrolle wiederholt über volumes die verbundenen Datenträger zu ermitteln.

### In der Lösung der Aufgabe dürfen Sie folgende Sprachkonzepte nicht verwenden:

- dynamische Typabfragen

    (über getClass und instanceof) und Typumwandlungen

- bedingte Anweisungen wie if- und switch-Anweisungen sowie bedingte Ausdrücke (= Ausdrücke der Form x?y:z)

-Werfen und Abfangen von Ausnahmen

    Bauen Sie Ihre Lösung stattdessen auf (mehrfaches) dynamisches Binden auf.

### Warum die Aufgabe diese Form hat:

Die Aufgabe lässt Ihnen viel Entscheidungsspielraum. Es gibt zahlreiche sinnvolle Lösungsvarianten. Die Form der Aufgabe legt die Verwendung kovarianter Eingangsparametertypen nahe, die aber tatsächlich nicht unterstützt werden. Daher wird mehrfaches dynamisches Binden (durch simulierte Multi-Methoden bzw. das Visitor-Pattern) bei der Lösung hilfreich sein. Alternative Techniken, die auf Typumwandlungen und dynamischen Typabfragen beruhen, sind ausdrücklich verboten. Durch das Verbot bedingter Anweisungen und bedingter Ausdrücke wird die Notwendigkeit für dynamisches Binden noch verstärkt. Sie sollen sehen, wie viel mit dynamischem Binden möglich ist, aber auch, wo ein übermäßiger Einsatz zu Problemen führen kann. Anders als bei den vorangegangenen Aufgaben gibt es keine vorgeschriebenen Testfälle, die zur Selbstkontrolle genutzt werden könnten.
Was im Hinblick auf die Beurteilung zu beachten ist:
Schwerpunkte bei der Beurteilung liegen auf der selbständigen Entwicklung geeigneter Untertypbeziehungen und dem Einsatz (mehrfachen) dynamischen Bindens.

### Kräftige Punkteabzüge gibt es für

- die Verwendung der verbotenen Sprachkonzepte
- die Verwechslung von statischem und dynamischem Binden
- Verletzungen des Ersetzbarkeitsprinzips (also Vererbungsbeziehungen, die keine Untertypbeziehungen sind)
- nicht der Aufgabenstellung entsprechende oder falsche Funktionalität des Programms.

Punkteabzüge gibt es unter anderem auch für mangelhafte Zusicherungen, schlecht gewählte Sichtbarkeit und unzureichendes Testen (z.B. wenn grundlegende Funktionalität nicht überprüft wird).

### Wie die Aufgabe zu lösen ist:

Vermeiden Sie Typumwandlungen, dynamische Typabfragen und bedingte Anweisungen von Anfang an, da es schwierig ist, diese aus einem bestehenden Programm zu entfernen. Akzeptieren Sie in einem ersten Entwurf eher kovariante Eingangsparametertypen bzw. Multimethoden und lösen Sie diese dann so auf, dass Java damit umgehen kann.
Ein vollständiger Verzicht auf bedingte Anweisungen kann ungeahnte Schwierigkeiten nach sich ziehen. Verzichten Sie trotzdem auf bedingte Anweisungen und umgehen Sie die Schwierigkeiten mittels kreativer Lösungen, vor allem durch dynamisches Binden. Eine bedingte Anweisung lässt sich beispielsweise durch eine Schleife mit Abbruchbedingung simulieren. Verwenden Sie solche Techniken nur in Fällen, in denen tatsächlich eine Schleife ausgeführt werden soll bzw. eine Lösung mit dynamischem Binden unmöglich ist.

Halten Sie die Anzahl der Klassen, Interfaces und Methoden möglichst klein und überschaubar. Durch die Aufgabenstellung ist eine große Anzahl an Klassen und Methoden ohnehin kaum vermeidbar, und durch weitere unnötige Strukturierung oder Funktionalität könnten Sie bald den Überblick verlieren.

Es gibt mehrere sinnvolle Lösungsansätze. Bleiben Sie bei dem ersten von Ihnen gewählten sinnvollen Ansatz und probieren Sie nicht zu viele Ansätze aus, damit Ihnen nicht die Zeit davonläuft.

### Was im Hinblick auf die Abgabe zu beachten ist:
Verzichten Sie wie üblich auf die Verwendung von packages und Verzeichnissen innerhalb des Abgabeverzeichnisses. Gerade für diese Aufgabe ist es besonders wichtig, dass Sie (abgesehen von geschachtelten Klassen) nicht mehr als eine Klasse in jede Datei geben und auf aussagekräftige Namen achten. Sonst ist es schwierig, sich einen Überblick über Ihre Klassen und Interfaces zu verschaffen. Achten Sie darauf, dass Sie keine Java-Dateien abgeben, die nicht zu Ihrer Lösung gehören (alte Versionen, Reste aus früheren Versuchen, etc.).