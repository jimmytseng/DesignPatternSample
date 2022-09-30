package BehaviorPattern.CommandPattern;

public class CommandPattern {

	public static void main(String[] args) {
		Database database = new PostgressDatabase();
		DatabaseCommnad postgressDatabaseCommnad = new PostgressDatabaseCommnad(database);
		Invoke invoke = new Invoke();
		invoke.setDatabaseCommnad(postgressDatabaseCommnad);
		invoke.doCommit();
	}

}

interface DatabaseCommnad {
	public void commit();

	public void rollback();
}

class PostgressDatabaseCommnad implements DatabaseCommnad {

	private Database database;

	public PostgressDatabaseCommnad(Database database) {
		this.database = database;
	}

	@Override
	public void commit() {
		this.database.commit();
	}

	@Override
	public void rollback() {
		this.database.rollback();
	}

}

class Invoke {

	private DatabaseCommnad databaseCommnad;

	public void setDatabaseCommnad(DatabaseCommnad databaseCommnad) {
		this.databaseCommnad = databaseCommnad;
	}

	public void doCommit() {
		this.databaseCommnad.commit();
	}

}

interface Database {
	public void commit();

	public void rollback();
}

class PostgressDatabase implements Database {
	@Override
	public void commit() {
		System.out.println("postgres commit transaction");
	}

	@Override
	public void rollback() {
		System.out.println("postgres rollback transaction");
	}
}