SELECT
    dp.name AS DatabaseRoleName,
    m.name AS MemberName
FROM
    sys.database_role_members AS drm
INNER JOIN
    sys.database_principals AS dp
    ON drm.role_principal_id = dp.principal_id
INNER JOIN
    sys.database_principals AS m
    ON drm.member_principal_id = m.principal_id
WHERE
    dp.type = 'R' -- Role
    AND m.name = 'loja';
