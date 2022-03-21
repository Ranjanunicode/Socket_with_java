  /* Server side code . Establishing server */

  /* Importing necessary libraries */
    import java.net.*;  
    import java.io.*;  

    /* Creating MyServer class */
    class MyServer{  
    public static void main(String args[])throws Exception{  
    /* obtaining ServerSocket object which takes port address */
    ServerSocket ss=new ServerSocket(3333);  
    /* Socket object s to accept the data from client */
    Socket s=ss.accept();  
    DataInputStream din=new DataInputStream(s.getInputStream());  
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
    /* object for storing the strings into buffer reader */
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
      
    String str="start",str2="";  

    while(str.equals("start")){
      System.out.println("Client Connected");
      while(!str.equals("stop")){   
         /* storing the received data strings from client into buffer reader */
         str=din.readUTF();  
         /* Printing data received from client */
         System.out.println("client says: "+str);  
         str2=br.readLine();  
         /* encoding data which is to be sent to the client */
         dout.writeUTF(str2);  
         dout.flush();  
      }
    }  
    din.close();  /* pausing data input stream din */
    s.close();  /* closing socket s */
    ss.close();  /* closing socket ss */
    }}  
