# Utiliser une image OpenJDK comme base
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré par Maven/Gradle
COPY target/*.jar app.jar

# Exposer le port sur lequel l'application s'exécute
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]