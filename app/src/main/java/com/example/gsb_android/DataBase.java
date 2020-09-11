package com.example.gsb_android;

import android.database.Cursor;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.out;

public class DataBase {

    private Connection connexion;
    private static DataBase db = null;
    public static DataBase getDb() {

        if (db==null) {

                    try{

                        db = new DataBase();

                    }catch(Exception e){

                        throw new RuntimeException(e);
                    }

        }
        return db ;

    }

    private DataBase() throws SQLException, ClassNotFoundException {

        /* Connexion à la base de données */
        String url = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7364463";
        String utilisateur = "sql7364463";
        String motDePasse = "cURDNQQkDH";
        Statement statement= null;
        ResultSet rs = null;


            /* Chargement du driver JDBC pour MySQL */
            Class.forName("com.mysql.jdbc.Driver");
            /*Recuperation de la connexion*/
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connexion= DriverManager.getConnection(url, utilisateur, motDePasse);



            out.println("------------------>Connexion: "+connexion);

            /*Etablissement d'un Statement*/
            statement= connexion.createStatement();

//            String sql= "SELECT * FROM visiteur";

            CreateTable();
        if (statement!=null)statement.close();

        }










    //Propriétes
    private static final String NOMBDD = "sql7364463";
    private static final String TABLE_FRAIS = "CREATE TABLE FRAIS_FORFAIT (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TIMESTAMP, QUANTITE FLOAT)";
    private static final String TABLE_FRAISHF = "CREATE TABLE FRAISHFORFAIT (ID INTEGER PRIMARY KEY AUTOINCREMENT, LIBELLE VARCHAR(255), DATE TIMESTAMP, MONTANT FLOAT)";


    /**
     * Constructeur
     *
     * @param context
     */


    /**
     * Cree les tables FRAIS FORFAIT et FRAISHFORFAIT
     *
     */

    private void CreateTable() throws SQLException {
        Statement statement = connexion.createStatement();

        statement.executeUpdate(TABLE_FRAIS);
        statement.executeUpdate(TABLE_FRAISHF);

    }

//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS FRAIS_FORFAIT");
//        db.execSQL("DROP TABLE IF EXISTS FRAISHFORFAIT");
//        onCreate(db);
//    }

    /**
     * Insere les valeurs en parametres dans la table FRAIS FORFAIT
     *
     * @param id
     * @param mois
     * @param quantite
     * @return
     */
    public boolean insertData(String id, String mois, String quantite) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("ID", id);
//        contentValues.put("MOIS", mois);
//        contentValues.put("QUANTITE", quantite);
//        long result = db.insert("FRAIS_FORFAIT", null, contentValues);
//        return result != -1;
        return true;
    }

    /**
     * Insere les valeurs en parametres dans le table FRAISHFORFAIT
     *
     * @param libelle
     * @param date
     * @param montant
     * @return
     */
    public boolean insertDatafraisHF(String mois, String libelle, String date, String montant) {
        try{

            Statement statement = connexion.createStatement();

            int i = statement.executeUpdate("INSERT INTO FRAISHFORFAIT VALUES(NULL, " + libelle + ", " + date + "," + montant + ")");

            return i == 1;

        }catch(Exception E){

            E.printStackTrace();
            return false;
        }

//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("MOIS", mois);
//        contentValues.put("LIBELLE", libelle);
//        contentValues.put("DATE", date);
//        contentValues.put("MONTANT", montant);
//        long result = db.insert("FRAISHFORFAIT", null, contentValues);
//        return result != -1;


    }

    /**
     * Modifie le frais saisi
     *
     * @param id
     * @param mois
     * @param quantite
     * @return
     */
    public boolean modifDatafrais(String id, String mois, String quantite) {
//        out.println(id + " " + mois + " " + quantite);
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("QUANTITE", quantite);
//        long result = db.update("FRAIS_FORFAIT", contentValues, "MOIS=" + "'" + mois + "'" + " AND ID=" + "'" + id + "'", null);
//        return result != -1;
        return true;
    }

    /**
     * Modifie le frais hors forfait saisi
     *
     * @param id
     * @param libelle
     * @param montant
     * @return
     */
    public boolean modifDatafraisHF(String id, String libelle, String montant) {
//        out.println(id + " " + libelle + " " + montant);
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("LIBELLE", libelle);
//        contentValues.put("MONTANT", montant);
//        long result = db.update("FRAISHFORFAIT", contentValues, "ID=" + "'" + id + "'", null);
//        return result != -1;
        return true;
    }

    /**
     * supprime le frais selectionné
     *
     * @param id
     * @param mois
     * @return
     */
    public boolean supprimDatafrais(String id, String mois) {
//        out.println(id + " " + mois);
//////        SQLiteDatabase db = this.getWritableDatabase();
//////        long result = db.delete("FRAIS_FORFAIT", "MOIS=" + "'" + mois + "'" + " AND ID=" + "'" + id + "'", null);
//////        return result != -1;
        return true;
    }

    /**
     * supprime le frais hors forfait selectionné
     *
     * @param id
     * @return
     */
    public boolean supprimDatafraisHF(String id) {
//        out.println(id);
//        SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.delete("FRAISHFORFAIT", "ID=" + "'" + id + "'", null);
//        return result != -1;
        return true;
    }

    /**
     * recupere les valeurs de la table FRAIS FORFAIT
     *
     * @return
     */
    public Cursor viewData() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "select * from FRAIS_FORFAIT";
//        Cursor cursor = db.rawQuery(query, null);
//        return cursor;
        return null;
    }

    /**
     * recupere les valeurs de la table FRAISHFORFAIT
     *
     * @return
     */
    public Cursor viewDataFraisHF() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "select * from FRAISHFORFAIT";
//        Cursor cursor = db.rawQuery(query, null);
//        return cursor;
        return null;
    }
}
