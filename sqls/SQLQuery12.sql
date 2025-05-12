EXECUTE AS USER = 'loja';
SELECT * FROM fn_my_permissions(NULL, 'DATABASE');
REVERT;
