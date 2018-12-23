package rule.pattern.itf;

public interface Application 
{
	void init();
	void idle();
	void cleanup();
	boolean done();
}
