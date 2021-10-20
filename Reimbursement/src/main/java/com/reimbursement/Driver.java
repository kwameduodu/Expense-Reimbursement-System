package com.reimbursement;

import javax.servlet.http.HttpSession;

import com.reimbursement.controller.ApprovalController;
import com.reimbursement.controller.ReimbursementController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Driver {

	public static void main(String...main) {
		
		//I'm starting my server on port 8000.
		Javalin app = Javalin.create().start(8000);
		
		app.post("/login", ctx -> {
			//If user credentials are correct, grant an HttpSession:
			ctx.req.getSession();
		});
		
		app.get("/logout", ctx -> {
			//If you pass in "false", an existing session is checked for.
			HttpSession session = ctx.req.getSession(false);
			if(session != null) session.invalidate();
		});
		
		app.after(ctx -> {
			ctx.res.addHeader("Access-Control-Allow-Origin", "null");
		});
		
		app.config.addStaticFiles("/static", Location.CLASSPATH);
		
		ReimbursementController reimburseController = new ReimbursementController(app);
		ApprovalController approvalController = new ApprovalController(app);
	}
}
