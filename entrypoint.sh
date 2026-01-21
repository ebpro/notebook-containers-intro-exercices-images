#!/bin/sh
# Si MAIN_CLASS est vide -> utiliser app.App1
MAIN_CLASS="${MAIN_CLASS:-app.App1}"

# Lancer l'application
exec java -cp "app.jar" "$MAIN_CLASS"
