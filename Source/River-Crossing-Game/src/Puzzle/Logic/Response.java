package Puzzle.Logic;

public class Response {
	
	boolean isValid;
	String msg;
	
	public Response() {
		this.isValid = false;
		this.msg = "empty class";
	}

	public Response(Boolean isValid, String msg) {
		this.isValid = isValid;
		this.msg = msg;
	}
	
	public boolean isValid()
	{
		return isValid;
	}
	
	public String getMsg()
	{
		return msg;
	}
	
	@Override
	public String toString() {
		return "Response [bol=" + isValid() + ", str=" + getMsg() + "]";
	}
	
}
