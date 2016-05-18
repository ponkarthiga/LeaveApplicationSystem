package com.pactera.dao;

public abstract class DaoFactory {
    // List of DAO types supported by the factory.
    /** Indicates an Oracle database. */
    public static final int ORACLE = 0;
    /** Indicates a MySQL database. */
    public static final int MYSQL = 1;
    
    /**
     * Returns the concrete DAO factory based on the selected database type.
     *
     * @return  the concrete DAO factory
     */
    public static DaoFactory getDaoFactory(int whichFactory) {
        switch (whichFactory) {
        case MYSQL:
            return new MySqlDaoFactory();
        case ORACLE:
            return null;
        default:
            return null;
        }
    }
    
    /**
     * Returns the DAO for <code>UserBean</code> object instances.
     *
     * @return  the DAO for <code>UserBean</code>
     */
    public abstract UserDao getUserDao();
    
    public abstract LeaveDao getLeaveDao();
}
