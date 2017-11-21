import java.io.*;
import java.util.*;
//import java.lang.*;
class UserData 
{
	//Setting userdata
	private int UserID;
	private String Gender;
	private int Age;
	private int Occupation;
	private double ZipCode;
	public int  getUserID() 
	{
		return UserID;
	}
		public void   setUserID(int UserID) 
		{
			//System.out.print(" "+UserID);
			this.UserID = UserID;
		}
	public void setGender(String Gender) 
	{
		//System.out.print(" "+Gender);
		this.Gender = Gender;
	}
	public int getAge() 
	{
	return Age;
	}
	public void setAge(int Age) 
	{
		//System.out.print(" "+Age);
		this.Age = Age;
	}
	public void setZipCode(double ZipCode)
	{
		//System.out.print(" "+ZipCode);
		this.ZipCode=ZipCode;
	}
	public double getZipCode()
	{
		return ZipCode;
	}
	
	public int getOccupation() 
	{
	return Occupation;
	}
	public void setOccupation(int Occupation)
	{	
	//System.out.print(" "+Occupation);
	this.Occupation = Occupation;
	}
	
}
class Users extends UserData
{
	public void myUser(Hashtable<Integer,Integer> hs3) throws IOException
	{
		 int i=0;
		try{
			
		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader("Users.csv"));
         ArrayList<Integer> a=new ArrayList<Integer>(); 
		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<UserData> uList = new ArrayList<>();
         int count=0;
		while ((line = reader.readLine()) != null) 
		{
			UserData u = new UserData();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) 
				{
				String data = scanner.next();
				if (index == 0)
				{
				
				u.setUserID(Integer.parseInt(data));
				int j=Integer.parseInt(data);
				 a.add(j);
				}
				else if (index == 1)
					u.setGender(data);
				else if (index == 2)
				{
					u.setAge(Integer.parseInt(data));
					int k=a.get(i++);
					//emp.setRating (Integer.parseInt(data));
					 int age=Integer.parseInt(data);
					 if(hs3.containsKey(k))
					 {
						 int c=hs3.get(k);
						 hs3.put(k,age+c);
					 }
					 else
						 hs3.put(k,age);
				}
				else if (index == 3)
				{
					u.setOccupation(Integer.parseInt(data));
				}
				else if(index==4)
				{u.setZipCode(Double.parseDouble(data));
				 System.out.println();
				}				
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			uList.add(u);
		
		}
		
		//close reader
		reader.close();
		
		}//System.out.print(uList);
		
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	
}
class RatingData 
	{
	//Setting Rating data
	private int UserID;
	private int MovieID;
	private int Rating ;
	private int Timestamp;
	public int  getUserID() {
		return UserID;
	}
	public void setUserID(int UserID) {
		//System.out.print(" "+UserID);
		this.UserID = UserID;
	}
	public void setMovieID(int MovieID) 
	{
	//	System.out.print(" "+MovieID);
		this.MovieID = MovieID;
	}
	public int getRating () {
	return Rating ;
	}
	public void setRating (int Rating ) {
		//System.out.print(" "+Rating );
		this.Rating  = Rating ;
	}
	public int getTimestamp() {
	return Timestamp;
	}
	public void setTimestamp(int Timestamp)
	{	
//	System.out.print(" "+Timestamp);
	this.Timestamp = Timestamp;
	}
	
}
class Ratings extends RatingData
{
	public void myRatings(Hashtable<Integer,Integer> hs,Hashtable<Integer,Integer> hs3) throws IOException
	{
		try{
			
		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader("Ratings.csv"));
         int j=0;
		 int i=0;
		 ArrayList<Integer> a=new ArrayList<Integer>(); 
		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		//List<RatingData> empList = new ArrayList<>();
       int count=0;
	   int rate;
		while ((line = reader.readLine()) != null) {
			RatingData emp = new RatingData();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
				emp.setUserID(Integer.parseInt(data));
			else if (index == 1)
				{ 
					j=Integer.parseInt(data);
					a.add(j);
					if(hs.containsKey(j))
			         {
				     int c=hs.get(j);
				     hs.put(j,++c);
			         }
			         else
				    hs.put(j,1);
				}
				else if (index == 2)
				{ 
			
			      int k=a.get(i++);
					//emp.setRating (Integer.parseInt(data));
					 rate=Integer.parseInt(data);
					 if(hs3.containsKey(k))
					 {
						 int c=hs3.get(k);
						 hs3.put(j,c+rate);
					 }
					 else
						 hs3.put(k,rate);
				}
				else if(index==3)
				{emp.setTimestamp(Integer.parseInt(data));
				 //System.out.println();
				}				
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			//empList.add(emp);
		
		}
		
		//close reader
		reader.close();
		
		//System.out.print(empList);
		
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}
class Movies {
	private int MovieID;
	private String Title;
	private String Genres;
	public int  getMovieID() {
		return MovieID;
	}
	public void setMovieID(int MovieID) {
		//System.out.print(" "+MovieID);
	}
	public void setTitle(String Title) 
	{
		this.Title=Title;
		//System.out.print(" "+Title);
		
	}

	public void setGenres(String  Genres) {
		//System.out.print(" "+ Genres);
		this. Genres =  Genres;
	}

}
class MovieInfo extends Movies
{ 
   //Movies ms = new Movies();
      
	public void myMovies(Hashtable<Integer,String> hs) throws IOException
	{
		 int i=0;
		try{
			
		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader("Movies.csv"));
		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<Movies> empList = new ArrayList<>();
         
		 String str;
		while ((line = reader.readLine()) != null) {
			Movies emp = new Movies();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				
				String data = scanner.next();
				if (index == 0)
				{
				emp.setMovieID(Integer.parseInt(data));
				 i=Integer.parseInt(data);
				}
				else if (index == 1){
					//emp.setTitle(data);
					str=data;
					hs.put(i,str);
				}
				else if (index == 2){
					emp.setGenres(data);
					//System.out.println();
				}
				else
					System.out.println("invalid data::" + data);
				index++;
				
			}
			
			index = 0;
			empList.add(emp);
			
		     
		}
				
		//close reader
		reader.close();
		
		
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
		
	}
}
class Testing
 {
public static void sortValue(Hashtable<Integer, Integer> t){
              
       //Transfer as List and sort it
       ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList(t.entrySet());
       Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>(){

         public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }});
   
    }
	public static void main(String[] args) throws IOException 
	{
        int x=0;
		int y=0;
		int z=0;
		int c=0;
		int cc=0;

	 Hashtable<Integer,String> hs1=new Hashtable<Integer,String>(); 
	 Hashtable<Integer,Integer> hs2=new Hashtable<Integer,Integer>(); 
	 Hashtable<Integer,Integer> hs3=new Hashtable<Integer,Integer>(); 
	 Hashtable<Integer,Integer> hs4=new Hashtable<Integer,Integer>();

		MovieInfo obj2=new MovieInfo();
		obj2.myMovies(hs1);
		Ratings obj3=new Ratings();
		Users obj4=new Users();
		obj4.myUser(hs4);
		obj3.myRatings(hs2,hs3);

		//To sort based on user_id
		Testing.sortValue(hs2);
		System.out.println("1. Top ten most viewed movies with their movies Name (Ascending or Descending order))");
		Enumeration<Integer> keys = hs2.keys();
        while(keys.hasMoreElements())
		{
            Integer key = keys.nextElement();
			if(hs1.containsKey(key) && hs2.get(key)>1763)
			{
            System.out.println("Value of "+key+" is: "+hs1.get(key)+" "+"Total :---"+hs2.get(key));
            
			}
		}
		System.out.println();
		System.out.println("2. Top twenty rated movies (Condition: The movie should be rated/viewed by at least 40 users)");
		Enumeration<Integer> keyss = hs2.keys();
        while(keyss.hasMoreElements())
		{
            Integer key = keyss.nextElement();
			if(hs1.containsKey(key) && hs2.get(key)>=900&& c<=20)
		{
				
            System.out.println("Value of "+key+" is: "+hs1.get(key)+" "+"--Total Rate-"+hs3.get(key));
            c++;
		}
		}
		System.out.println();
		System.out.println();
		System.out.println("movies based on following Age Gruops");
		Enumeration<Integer> keysss1 = hs4.keys();
        while(keysss1.hasMoreElements())
		{
            Integer key = keysss1.nextElement();
			if(hs2.containsKey(key) && hs2.get(key)>=35 && hs4.get(key)<18 && x<=18){
				x++;
            System.out.println("Value of "+key+" is: "+hs1.get(key)+" "+"--Current Age-"+hs4.get(key));
            
			}
		}
		System.out.println();
		System.out.println();
		Enumeration<Integer> keysss2 = hs4.keys();
        while(keysss2.hasMoreElements())
		{
            Integer key = keysss2.nextElement();
	    if(hs2.containsKey(key) && hs2.get(key)>=50 && hs4.get(key)>=36 && hs4.get(key)<50 && y<=36)
			{
				y++;
            System.out.println("Value of "+key+" is: "+hs1.get(key)+" "+"--Current Age-"+hs4.get(key));
            
			}
		}
		System.out.println();
		System.out.println();
		Enumeration<Integer> keysss3 = hs4.keys();
        while(keysss3.hasMoreElements())
		{
            Integer key = keysss3.nextElement();
	    if(hs2.containsKey(key) && hs2.get(key)>=50 && hs4.get(key)>50 && z<=50){
				z++;
            System.out.println("Value of "+key+" is: "+hs1.get(key)+" "+"--Current Age-"+hs4.get(key));
            
			}
		}		
	}
 }
