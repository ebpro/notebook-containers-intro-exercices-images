# hello-java — Instructions et vérifications

Ce dépôt contient plusieurs variantes d'un petit projet Java/Maven et des Dockerfiles pédagogiques :

- `Dockerfile` : exemple simple (JDK -> build + run dans la même image).
- `Dockerfile.arg_env` : montre l'usage de `ARG`, `ENV` et `LABEL`.
- `Dockerfile.multistage` : build multi-stage (JDK) puis image runtime (JRE), utilisation de cache Maven (`--mount`) et user non-root.
- `entrypoint.sh` : script d'entrée qui lance la classe définie par la variable `MAIN_CLASS`.

## Prérequis

- Docker installé et fonctionnel.
- Java (pour exécuter localement sans Docker) et Maven si vous voulez compiler localement.

## Commandes utiles

Build simple (Dockerfile) :

```bash
docker build --quiet -f Dockerfile -t hello-java:plain .
docker run --rm hello-java:plain
```

App2 avec variables d'environnement :

```bash

docker build --quiet -f Dockerfile.arg_env --build-arg GIT_COMMIT=abc123 -t hello-java:env .

docker run --rm -e MAIN_CLASS=app.App2 hello-java:env
docker run --rm -e MAIN_CLASS=app.App2 -e LOG_LEVEL=INFO hello-java:env
```

Build et run multi-stage (avec BuildKit pour bénéficier du cache Maven) :

```bash
docker build --quiet -f Dockerfile.multistage -t hello-java:multi .
docker run --rm -e MAIN_CLASS=app.App3 hello-java:multi
```

## Tester localement (sans Docker)

```bash
./mvnw -q package
java -jar target/hello-java-0.0.1.jar
```

Points importants à vérifier

- `.dockerignore` : exclut `target`, `.m2`, `.git` pour réduire le contexte de build.
- Non-root : `Dockerfile.multistage` montre la création d'un utilisateur non-root — bonne pratique de sécurité.
- Taille d'image : comparer image multi-stage (runtime only) vs image contenant le JDK.

```bash
# Lister les images construites
docker images | grep hello-java
```
