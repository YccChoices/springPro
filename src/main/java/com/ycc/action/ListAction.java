package com.ycc.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ycc.model.Product;
import com.ycc.service.ProductService;

public class ListAction extends ActionSupport {
	
	//商品service IOC
	private ProductService productService;
	
	//商品链表
	private List< Product > productlist;
	
	//获的商品ID
	private Long productId;
	
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;

	private HttpSession session;
	
	private ServletContext application;
	 
	 
	 //传输时缩小图片大小
	 
/*	private  String imageUrl;

	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
*/
	 //添加分页 
	 
	 private int page; 
	 private int maxpage;
	 private int type;
	 
	 
	 
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	// page maxpage 放入request 
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	
	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/*public String list( )
	{
		productlist = this.productService.getALLProducts();
		
		return"list";
	}*/
	
	
	public String list( )
	{
		this.request = ServletActionContext.getRequest();
		
		int maxpage = this.productService.maxSize();
		
		int pageNo  =1;
		
		int pageSize = 5;
		
		if( page >  0 )
		{
			pageNo = page;
		}
		
		
		productlist = this.productService.getByPage(pageNo , pageSize );
		
		request.setAttribute("page", pageNo);
		
		request.setAttribute("maxpage", maxpage);
		System.out.println("进入listaction");
		return"list";
	}
	
		
	
//	public  String addItem( )
//	{
//		String ret = "add";
//		
//		System.out.println(productId);
//		
//		Product product = this.productService.getProduct(productId);
//		
//		this.request = ServletActionContext.getRequest();
//
//		 this.session = this.request.getSession();
//		
//		Cart cart = (Cart) this.session.getAttribute( Constants.SESSION_CART);
//		
//		if( cart == null )
//		{
//			cart = new Cart( );
//			
//			this.session.setAttribute(Constants.SESSION_CART, cart );
//		}
//		
//		cart.addItem(product, 1);
//		
//		System.out.println( cart.getPrice() );
//		
//		//System.out.println("type:" + type );
//		
//		
//		if( type == 1 )
//		{
//			ret ="find";
//			
//			// bug  获取type后注意恢复
//			
//			type = 0;
//		}
//		
//		return ret;
//	}
	//传输时缩小图片大小
	
	/*public void showImage( )
	{
		
		
		request = ServletActionContext.getRequest();
		
		response = ServletActionContext.getResponse();
		
		String url = imageUrl.substring(0, imageUrl.length() -3 );
		
		com.cn.shop.util.ZipImage.zip(request, response, url );
	}
	*/

}
