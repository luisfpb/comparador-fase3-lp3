package com.mackenzie.ep.buscador.client;

import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class BuscadorCliente {
	public static void main(String[] args) {
		try {
			ResteasyClient client = new ResteasyClient();
			ResteasyWebTarget target = client
					.target("http://localhost:8080/rest/services/Produtos.json");
			Response response = target.request().get();
			if (response.getStatus() != 200){
			        throw new RuntimeException("Failed : HTTP error code : "
			        		+ response.getStatus());
			        }
			        System.out.println("Server response : \n");
			        System.out.println(response.readEntity(String.class));
			        response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}
}
