# Définir l'image de base
FROM eclipse-temurin:21-jdk

# Definir le répertoire de travail
WORKDIR /app

# Copier les fichiers du projet dans le conteneur
COPY . .

# Construire l'application avec Maven Wrapper
RUN ./mvnw -q package

# Définir la commande de démarrage
CMD ["java", "-jar", "target/hello-java-0.0.1.jar"]
