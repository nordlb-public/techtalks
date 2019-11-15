#!/bin/sh
cd /var/www/html

php artisan migrate --force

apache2-foreground