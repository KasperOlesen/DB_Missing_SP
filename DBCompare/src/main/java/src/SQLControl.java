package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kAlex
 */
public class SQLControl {
    
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/comparesql";
    String user = "root";
    String password = "password";

    public ResultSet getEndorsesDepthOne(int id) {
        String query = "SELECT NAME "
                    + "FROM T_USER "
                    + "WHERE T_USER.ID IN "
                        + "(SELECT ENDORSED "
                        + "FROM T_ENDORSEMENTS "
                        + "WHERE ENDORSER = " + id + ")";
        try {
            con = DriverManager.getConnection(url, user, password);
            return con.createStatement().executeQuery(query);
        } catch (SQLException ex) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public ResultSet getEndorsesDepthTwo(int id) {
        String query = "SELECT NAME "
                    + "FROM T_USER "
                    + "WHERE T_USER.ID IN "
                        + "(SELECT ENDORSED "
                        + "FROM ENDORSER IN "
                            + "(SELECT ENDORSED "
                            + "FROM T_ENDORSEMENTS "
                            + "WHERE ENDORSER = " + id + ")";
        try {
            con = DriverManager.getConnection(url, user, password);
            return con.createStatement().executeQuery(query);
        } catch (SQLException ex) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public ResultSet getEndorsesDepthThree(int id) {
        String query = "SELECT NAME "
                    + "FROM T_USER "
                    + "WHERE T_USER.ID IN "
                        + "(SELECT ENDORSED "
                        + "FROM ENDORSER IN "
                            + "(SELECT ENDORSED "
                            + "FROM T_ENDORSEMENTS "
                            + "WHERE IN "
                                + "(SELECT ENDORSED "
                                + "FROM T_ENDORSEMENTS "
                                + "WHERE ENDORSER = " + id + ")";
        try {
            con = DriverManager.getConnection(url, user, password);
            return con.createStatement().executeQuery(query);
        } catch (SQLException ex) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public ResultSet getEndorsesDepthFour(int id) {
        String query = "SELECT NAME "
                    + "FROM T_USER "
                    + "WHERE T_USER.ID IN "
                        + "(SELECT ENDORSED "
                        + "FROM ENDORSER IN "
                            + "(SELECT ENDORSED "
                            + "FROM T_ENDORSEMENTS "
                            + "WHERE IN "
                                + "(SELECT ENDORSED "
                                + "FROM T_ENDORSEMENTS "
                                + "WHERE IN "
                                    + "(SELECT ENDORSED "
                                    + "FROM T_ENDORSEMENTS "
                                    + "WHERE ENDORSER = " + id + ")";
        try {
            con = DriverManager.getConnection(url, user, password);
            return con.createStatement().executeQuery(query);
        } catch (SQLException ex) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public ResultSet getEndorsesDepthFive(int id) {
        String query = "SELECT NAME "
                    + "FROM T_USER "
                    + "WHERE T_USER.ID IN "
                        + "(SELECT ENDORSED "
                        + "FROM ENDORSER IN "
                            + "(SELECT ENDORSED "
                            + "FROM T_ENDORSEMENTS "
                            + "WHERE IN "
                                + "(SELECT ENDORSED "
                                + "FROM T_ENDORSEMENTS "
                                + "WHERE IN "
                                    + "(SELECT ENDORSED "
                                    + "FROM T_ENDORSEMENTS "
                                    + "WHERE IN "
                                        + "(SELECT ENDORSED "
                                        + "FROM T_ENDORSEMENTS "
                                        + "WHERE ENDORSER = " + id + ")";
        try {
            con = DriverManager.getConnection(url, user, password);
            return con.createStatement().executeQuery(query);
        } catch (SQLException ex) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
        return null;
    }
}
