# JAVA-SIMULATOR
Framework-Persistence-Simulator
----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------

Le but du mini-projet est de réaliser un simulateur de charge des Framework de persistance. Il simule le cas de mille utilisateurs qui veulent se connecter en même temps. Et on va voir comment notre serveur va répondre. 
Le simulateur sera piloté par une classe principale qui se basera sur le mécanisme de Thread pour lancer aléatoirement et en même temps les requêtes CRUD, à savoir :  la création, la lecture, la mise à jour et la suppression.
Le résultat de chaque opération (Opération, temps d'exécution, Thread) sera stocké dans une collection qui supportera le contexte de Thread.
En générale, il y a trois manières de faire : JDBC-DAO-Hibernate. Une analyse détallée des résultats stockés(le temps total et moyen pour chaque Framework dans un fichier texte) nous permettra de conclure le meilleur Framework.

----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------

This is a school mini-project, realized in order to get familiar with advanced Java tools and frameworks.

The goal of this mini project is to create a simulator that measures Framework Persistence, such as: 
 - JDBC: Java Database Connectivity
 - DAO: Data Access Object Patten
 - Hibernate

The goal is to measure through a series of creation, update and removal operations the fastest framework.

The simulator will be driven by a main class that will use the Thread mechanism to randomly launch CRUD (Create-Read-Update-Delete) operations.

The result of each operation (Operation, execution time and Thread) will be stored in a collection that will support the Thread context.
Once measured, the total and average time for each Framework will be stored in a text file.

Finally, the text files will be analyzed to detect the best optimal framework.


----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------

project realized By:
        - EL KHAOUI MAROUA
        - TAIFOUR MOUAD
        - AZOUGAY R'KIA
