package generics;
	
 class Response<T> {
    T data;
    String message;
    int status;

    void setResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    T getData() {
        return data;
    }

    String getMessage() {
        return message;
    }

    int getStatus() {
        return status;
    }
}
 

	     
 
 
 
 
public class ex2 {
 
	public static void main(String[] args) {
		
		
        Response<Integer> r1 = new Response<>();
        r1.setResponse(100, "Success", 200);

        System.out.println(r1.getData());
        System.out.println(r1.getMessage());
        System.out.println(r1.getStatus());
        
        Response<String> r2 = new Response<>();
        r2.setResponse("Kadhir", "User Found", 200);

        System.out.println(r2.getData());
        System.out.println(r2.getMessage());
        System.out.println(r2.getStatus());
		
	}
	
	
	
}
