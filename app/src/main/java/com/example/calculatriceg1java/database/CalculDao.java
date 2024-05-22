package com.example.calculatriceg1java.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.calculatriceg1java.entities.Calcul;

public class CalculDao  extends BaseDao<Calcul> {
    public static String tableName = "historique";
    public static String premierElement="PREMIER_ELEMENT";
    public static String deuxiemeElement="DEUXIEME_ELEMENT";
    public static String symbol="SYMBOLE";
    public static String resultat="RESULTAT";

    public CalculDao(DatabaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return tableName;
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(premierElement,entity.getPremierElement());
        values.put(deuxiemeElement,entity.getDeuxiemeElement());
        values.put(symbol,entity.getSymbole());
        values.put(resultat,entity.getResultat());
    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        Calcul toReturn = new Calcul();
        Integer indexPremierElement = cursor.getColumnIndex(premierElement);
        toReturn.setPremierElement(cursor.getInt(indexPremierElement));
        Integer indexDeuxiemeElement = cursor.getColumnIndex(deuxiemeElement);
        toReturn.setDeuxiemeElement(cursor.getInt(indexDeuxiemeElement));
        Integer indexSymbole = cursor.getColumnIndex(symbol);
        toReturn.setSymbole(cursor.getString(indexSymbole));
        Integer indexResultat = cursor.getColumnIndex(resultat);
        toReturn.setResultat(cursor.getInt(indexResultat));
        return toReturn;
    }
}
