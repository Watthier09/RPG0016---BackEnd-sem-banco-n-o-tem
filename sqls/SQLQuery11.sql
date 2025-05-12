USE master;

CREATE USER loja FOR LOGIN loja;

ALTER ROLE db_owner ADD MEMBER loja;
