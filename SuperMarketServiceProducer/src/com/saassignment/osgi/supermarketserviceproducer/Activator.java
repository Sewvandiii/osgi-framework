package com.saassignment.osgi.supermarketserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.saassignment.osgi.cashierservice.CashierService;
import com.saassignment.osgi.cashierserviceimpl.CashierServiceImpl;
import com.saassignment.osgi.managerservice.ManagerService;
import com.saassignment.osgi.managerserviceimpl.ManagerServiceImpl;

public class Activator implements BundleActivator {
	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Supermarket service started.============");
		CashierService cashierSer = new CashierServiceImpl();
		serviceRegisterer = context.registerService(CashierService.class.getName().toString(), cashierSer, null);//registering the cashierService
		ManagerService managerSer = new ManagerServiceImpl();
		serviceRegisterer = context.registerService(ManagerService.class.getName(), managerSer, null); //registering the managerService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("==============Supermarket service closed.=============");
		serviceRegisterer.unregister();
	}

}
