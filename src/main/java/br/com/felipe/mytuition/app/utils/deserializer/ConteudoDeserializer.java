package br.com.felipe.mytuition.app.utils.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.felipe.mytuition.app.api.dto.materia.ConteudoDTO;

public class ConteudoDeserializer extends JsonDeserializer<ConteudoDTO> {

	@Override
	public ConteudoDTO deserialize(JsonParser jp, DeserializationContext arg1)
			throws IOException {

		ObjectMapper mapper = (ObjectMapper) jp.getCodec();
		ObjectNode root = mapper.readTree(jp);

		Class<? extends ConteudoDTO> conteudoDTOClass = null;

		if (isTeoria(root)) {
//			conteudoDTOClass = TeoriaDTO.class;
		} else {
//			conteudoDTOClass = ExercicioDTO.class;
		}
		
		return mapper.readValue(jp, conteudoDTOClass);

	}

	private boolean isTeoria(ObjectNode root) {
		return root.get("texto") != null ? true : false;
	}

}
