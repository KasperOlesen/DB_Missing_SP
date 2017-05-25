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
    String url = "jdbc:mysql://localhost:3306/sqlcompare";
    String user = "root";
    String password = "centriNo100";

    public ResultSet getEndorsesDepthOne(int id) {
        String query = "SELECT NAME "
                    + "FROM t_user "
                    + "WHERE t_user.ID IN "
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
                    + "FROM t_user "
                    + "WHERE t_user.ID IN "
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
                    + "FROM t_user "
                    + "WHERE t_user.ID IN "
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
                    + "FROM t_user "
                    + "WHERE t_user.ID IN "
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
                    + "FROM t_user "
                    + "WHERE t_user.ID IN "
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
