docker-compose exec postgres pgloader \
mysql://root:root@mysql:3306/world \
postgresql://postgres:root@postgres:5432/postgres

#alter schema public rename to world

# Время ожидания (в секундах)
sleep 100
