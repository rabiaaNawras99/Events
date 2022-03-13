import java.util.*;
public class Comment // I changed the variable type of count to Static due to the code not working properly otherwise!
{
	private int cId;
	private Date startedService;
	private String content;
	private static int count=0;
	private Citizen citizen;
	//constructor
	public Comment(Date startedService,String content,Citizen citizen)
	{
		Comment.count++;
		this.cId=count;
		this.startedService=startedService;
		this.content=content;
		this.citizen=citizen;
	}
	//get and set
	public int getCId()
	{
		return this.cId;
	}
	public Date getStartedService()
	{
		return this.startedService;
	}
	public String getContent()
	{
		return this.content;
	}
	public int getCount()
	{
		return Comment.count;
	}
	public Citizen getCitizen()
	{
		return this.citizen;
	}
	
	public void setStartedService(Date startedService)
	{
		this.startedService=startedService;
	}
	public void setContnet(String content)
	{
		this.content=content;
	}
	public void setCitizen(Citizen citizen)
	{
		this.citizen=citizen;
	}
	//equals
	public boolean equals(Object c)
	{
		if(c instanceof Comment)
			if(this.getCId()==((Comment)c).getCId()) // �� ����� ����� ����
				return true;
		return false;
	}
	//to string
	public String toString()
	{
		return "Comment:\nID: "+this.cId+"\nDate: "+this.startedService+"\nContent: "+this.content+"\nCitizen: "+this.citizen;
	}
}
