package com.leonardorifeli.hermes.social.api;

import com.leonardorifeli.hermes.social.api.custom.business.enums.GithubStartJobQueueEnum;
import com.leonardorifeli.hermes.social.api.job.business.service.GithubSendMessageService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

@Path("/import/github")
@Produces("application/json")
public class GithubImportProccessResource {

	private GithubSendMessageService githubSendMessageService;
	
	private GithubStartJobQueueEnum jobQueueConfig;
	
	public GithubImportProccessResource() {
		this.githubSendMessageService = new GithubSendMessageService();
	}
	
	private String getQueueName() {
		return jobQueueConfig.getQueueName();
	}

	@GET
	@Path("{username}")
	public Response builderProccess(@PathParam("username") String username) {
		this.githubSendMessageService.start(username, "import", this.getQueueName());

		return Response.status(200).entity(this.getResult(username, true)).build();
	}

	private String getResult(String username, boolean status) {
		JSONObject message = new JSONObject();

		message.put("isStarted", status);
		message.put("username", username);

		return message.toString();
	}

}