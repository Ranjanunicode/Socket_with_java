 /* Client side code. Instance to connect server for text/message transfer/communication */

   /* Importing important libraries*/
    import java.net.*;  
    import java.io.*;  

    /* MyClient class*/
    class MyClient{  
    public static void main(String args[])throws Exception{  
    /* obtaining Socket object s with params ip adress and port number required */
    Socket s=new Socket("localhost",3333);  
    /* Data input Stream object din to read incomming data */
    DataInputStream din=new DataInputStream(s.getInputStream());  
    /* Data output Stream object din to read out going data */
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
    /* Buffer reader object for storing message data */
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
      
    String str="",str2="";  
    while(!str.equals("stop")){  
    /* storing the strings into buffer reader */
    str=br.readLine();  
    /* encoding the string for sending it to the server */
    dout.writeUTF(str); 
    /* Flushing/releasing sent data stored in dout. */
    dout.flush();  
    /* storing the received strings from server into buffer reader */
    str2=din.readUTF();  
    /* Printing received data from server*/
    System.out.println("Server says: "+str2);  
    }  
      
    dout.close();  /* pausing data output stream dout */
    s.close();  /* closing socket s */
    }}  
