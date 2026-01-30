# Définir l'image de base
FROM eclipse-temurin:21-jdk

# Definir le répertoire de travail
WORKDIR /app

# Copier les fichiers du projet dans le conteneur
COPY . .

# Construire l'application avec Maven Wrapper
RUN ./mvnw package -Pprod

# Définir la commande de démarrage

# Il est plus propre d'utiliser la syntaxe json comme nous le ferons plus tard
# mais pour faire simple ici nous utilisons la syntaxe shell qui support les les variables d'environnement et le globbing (*)

CMD java -jar target/hello-java-*.jar
