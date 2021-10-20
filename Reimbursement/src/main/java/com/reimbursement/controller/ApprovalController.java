package com.reimbursement.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import javax.servlet.http.HttpSession;

import com.reimbursement.model.Approval;
import com.reimbursement.service.ApprovalService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ApprovalController {


	private ApprovalService approvalService;
	
	public ApprovalController(Javalin app) {
		
		this.approvalService = new  ApprovalService();
		app.routes(() -> {
			path("/approve", () -> {
				
				path("/all", () -> {
					
					get(findAllApproval);
				});
				path("/new", () -> {
					post(saveApproval);
				});
			});
		});
	}
	
	private Handler findAllApproval = ctx -> {
		
		//To check for the existence of a session:
		HttpSession session = ctx.req.getSession();
		
		if(session != null)
			ctx.json(this.approvalService.findAll());
		else
			ctx.res.getWriter().write("You do not have a session.");
		
		};
		
	private Handler saveApproval = ctx -> {
		Approval approve = new Approval(2,ctx.req.getParameter("status"),ctx.req.getParameter("approveBy") );
		
		this.approvalService.save(approve);

		ctx.redirect("/approval.html");
		
	};
	
	
}
