package br.com.voxline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/teste")
public class TesteExposes implements Serializable {
	private static final long serialVersionUID = -1776976336725212337L;
	private Map<String, List<String>> listPersons = new HashMap<String, List<String>>();
	private List<String> names = new ArrayList<String>();

	@GET
	@Path("/persons")
	public Response persons() {
		names.add("João");
		names.add("Maria");
		names.add("Pedro");
		names.add("José");
		names.add("Gustavo");
		names.add("Pepa");
		listPersons.put("Persons", names);
		String responsePersons = new Gson().toJson(listPersons);
		return Response.ok(responsePersons, MediaType.APPLICATION_JSON).status(Response.Status.ACCEPTED).build();
	}

	@GET
	@Path("/conta")
	public Response resultFelipeViado(@QueryParam("x") String x) {
		Map<String, String> mapResultFelipeViado = new HashMap<String, String>();
		long valorLong = Long.parseLong(x);
		valorLong = valorLong * 5;
		mapResultFelipeViado.put("result", String.valueOf(valorLong));
		String responseFelipeViado = new Gson().toJson(mapResultFelipeViado);
		return Response.ok(responseFelipeViado, MediaType.APPLICATION_JSON).status(Response.Status.ACCEPTED).build();
	}

}
