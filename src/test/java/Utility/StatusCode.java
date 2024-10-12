package Utility;

public enum StatusCode {
	
	
	
	SUCCESS("OK",200),
	CREATED("CREATED",201),
	NOCONTENT("No Content",206),
	BADREQUEST("Bad request",400),
	UNAUTOHORIZED("Unauthorized",401),
	FORBIDDEN("Not allowed",403),
	NOCOntent("no content",205);
	
	
	public int codes;
	public String message;

	StatusCode(String message,int codes)
	{
		this.codes=codes;
		this.message=message;
	}
}
