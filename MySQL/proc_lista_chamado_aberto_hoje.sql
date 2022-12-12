
USE helpr;

DELIMITER //

CREATE PROCEDURE proc_lista_chamado_aberto_hoje()
BEGIN
	SELECT * FROM chamado WHERE data_abertura = CURDATE();
END//

DELIMITER ;

CALL proc_lista_chamado_aberto_hoje();