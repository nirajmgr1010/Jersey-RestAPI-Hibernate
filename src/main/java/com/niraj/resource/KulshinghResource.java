package com.niraj.resource;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("kulshingh")
public class KulshinghResource {
	
	KulshinghRepository repo = new KulshinghRepository();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Kulshingh> getKulshingh() {	
		
		return repo.getKulshinghs();
	}
    
    

    @GET
    @Path("kulshingh/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Kulshingh getKulshing(@PathParam("id") int id) {
    	return repo.getKulshingh(id);
    }	
    
    @POST
    @Path("kulshingh")
    public Kulshingh createKulshingh(Kulshingh k) {
    	System.out.println(k);
    	repo.create(k);
    	return k;
    }
    
    @PUT
    @Path("kulshingh")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Kulshingh UpdateKulshingh(Kulshingh k) {
    	System.out.println(k);
    	if(repo.getKulshingh(k.getId()).getId()==0){
    		repo.create(k);
    	}else {
    	repo.Update(k);
    	}
    	return k;
    }
    
    @DELETE
    @Path("kulshingh/{id}")
    public Kulshingh DeleteKulshingh(@PathParam("id") int id) {
     Kulshingh k = repo.getKulshingh(id);
     
     if(k.getId() != 0) {
     repo.delete(id);
     }
     return k;
    }
}
