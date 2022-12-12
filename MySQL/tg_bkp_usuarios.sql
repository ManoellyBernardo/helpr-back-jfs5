    CREATE TABLE helper_bkp.usuariobkp(
	    idBkpUsuario INTEGER PRIMARY KEY AUTO_INCREMENT,
        idUsuarios INTEGER NOT NULL,
        nome VARCHAR(150) NOT NULL,
        perfil VARCHAR(255) NOT NULL,
        dtype VARCHAR(31) NOT NULL,
        dataAlteracao DATE NOT NULL
);



DELIMITER //

CREATE TRIGGER tg_bkp_usuarios
BEFORE DELETE ON usuarios
FOR EACH ROW
BEGIN
	INSERT INTO helper_bkp.usuariobkp VALUES(NULL,OLD.id, OLD.nome, OLD.perfil, OLD.dtype, CURRENT_DATE());
END//

DELIMITER ;

DROP TRIGGER tg_bkp_usuarios;



SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM usuarios WHERE id =1;

SELECT * FROM helper_bkp.usuariobkp;
