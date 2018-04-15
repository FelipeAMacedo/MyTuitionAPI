package app.api;

import javax.ws.rs.core.Response;

import app.api.dto.wrapper.UsuarioSaveWrapper;

public interface UsuarioRestful {

	Response insert(UsuarioSaveWrapper wrapper);
}
