# Basis-Image für diesen Container ist nach wie vor php:apache
FROM php:apache

# damit Composer Pakete entpacken kann, müssen zip & unzip installiert sein
RUN apt-get update && apt-get install -y zip unzip

# der Anwendungscode wird in den Container kopiert
COPY . /var/www/html/

# Composer wird heruntergeladen & installiert
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Arbeitsverzeichnis wird gesetzt
WORKDIR /var/www/html

# Abhängigkeiten werden mittels Composer installiert
RUN composer install