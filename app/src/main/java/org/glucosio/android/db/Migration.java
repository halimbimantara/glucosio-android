package org.glucosio.android.db;

import java.util.Date;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class Migration implements RealmMigration {

    @Override
    public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        /************************************************
         // Version 0
         class GlucoseReading
             @PrimaryKey
             long id;

             int reading;
             String reading_type;
             String notes;
             int user_id;
             Date created;
         ************************************************/


        if (oldVersion == 0) {
            /************************************************
             // Version 1
             class CholesterolReading
                 @PrimaryKey
                 long id;

                 int totalReading;
                 int LDLReading;
                 int HDLReading;
                 Date created;

             class GlucoseReading
                 @PrimaryKey
                 long id;

                 int reading;
                 String reading_type;
                 String notes;
                 int user_id;
                 Date created;

             class KetoneReading
                 @PrimaryKey
                 long id;

                 long reading;
                 Date created;

             class PressureReading
                 @PrimaryKey
                 long id;

                 int minReading;
                 int maxReading;
                 Date created;

             class WeightReading
                 @PrimaryKey
                 long id;

                 int reading;
                 Date created;

             class HB1ACReading
                 @PrimaryKey
                 long id;
                 long reading;
                 Date created;
             ************************************************/


            RealmObjectSchema weightSchema = schema.create("WeightReading")
                    .addField("id", Long.class, FieldAttribute.PRIMARY_KEY, FieldAttribute.REQUIRED)
                    .addField("created", Date.class)
                    .addField("reading", Integer.class, FieldAttribute.REQUIRED);

            RealmObjectSchema pressureSchema = schema.create("PressureReading")
                    .addField("id", Long.class, FieldAttribute.PRIMARY_KEY, FieldAttribute.REQUIRED)
                    .addField("created", Date.class)
                    .addField("minReading", Integer.class, FieldAttribute.REQUIRED)
                    .addField("maxReading", Integer.class, FieldAttribute.REQUIRED);

            RealmObjectSchema ketoneSchema = schema.create("KetoneReading")
                    .addField("id", Long.class, FieldAttribute.PRIMARY_KEY, FieldAttribute.REQUIRED)
                    .addField("created", Date.class)
                    .addField("reading", Long.class, FieldAttribute.REQUIRED);

            RealmObjectSchema HB1ACSchema = schema.create("HB1ACReading")
                    .addField("id", Long.class, FieldAttribute.PRIMARY_KEY, FieldAttribute.REQUIRED)
                    .addField("created", Date.class)
                    .addField("reading", Integer.class, FieldAttribute.REQUIRED);

            RealmObjectSchema cholesterolSchema = schema.create("CholesterolReading")
                    .addField("id", Long.class, FieldAttribute.PRIMARY_KEY, FieldAttribute.REQUIRED)
                    .addField("created", Date.class)
                    .addField("totalReading", Integer.class, FieldAttribute.REQUIRED)
                    .addField("LDLReading", Integer.class, FieldAttribute.REQUIRED)
                    .addField("HDLReading", Integer.class, FieldAttribute.REQUIRED);
            oldVersion++;
        }
    }
}
