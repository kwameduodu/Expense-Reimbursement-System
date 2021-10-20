package com.reimbursement.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import javax.servlet.http.HttpSession;

import com.reimbursement.model.Approval;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.service.ReimbursementService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController {

	private ReimbursementService reimbursementService;
	
	public ReimbursementController(Javalin app) {
		
		this.reimbursementService = new  ReimbursementService();
		app.routes(() -> {
			path("/employee", () -> {
				
				path("/all", () -> {
					
					get(findAllReimbursemetn);
				});
				path("/new", () -> {
					post(saveReimbursement);
				});
			});
		});
	}
	
	private Handler findAllReimbursemetn = ctx -> {
		
		//To check for the existence of a session:
		HttpSession session = ctx.req.getSession();
		
		if(session != null)
			ctx.json(this.reimbursementService.findAll());
		else
			ctx.res.getWriter().write("You do not have a session.");
		
		};
		
	private Handler saveReimbursement = ctx -> {
		Reimbursement reimburse = new Reimbursement(2,ctx.req.getParameter("name"), ctx.req.getParameter("amount"), ctx.req.getParameter("reason"));
		
		this.reimbursementService.save(reimburse);

		ctx.redirect("/home.html");
		
	};
	
}
