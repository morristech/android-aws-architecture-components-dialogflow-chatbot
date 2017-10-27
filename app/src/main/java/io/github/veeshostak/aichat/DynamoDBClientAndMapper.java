package io.github.veeshostak.aichat;

// aws

import android.content.Context;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;
//import com.amazonaws.services.dynamodbv2.model.*;


public class DynamoDBClientAndMapper {

    // private AmazonDynamoDBClient ddbClient;
    private DynamoDBMapper mapper;

    public DynamoDBClientAndMapper(Context theApplicationContext) {

        // ==============
        // START aws

        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                theApplicationContext,
                "us-west-2:3a2e4c77-2472-4e03-9afd-a872d24d9377", // Identity pool ID
                Regions.US_WEST_2 // Region
        );

        //String identityId = credentialsProvider.getIdentityId();
        //Log.d("LogTag", "my ID is " + identityId);

        // NOTE: the default endpoint of the created AmazonDynamoDBClient is
        // us-east-1, we must set the correct region

        //ddbClient = new AmazonDynamoDBClient(credentialsProvider); // uses the default, wrong region

        AmazonDynamoDBClient ddbClient = Region.getRegion(Regions.US_WEST_2)
                .createClient(
                        AmazonDynamoDBClient.class,
                        credentialsProvider,
                        new ClientConfiguration()
                );

        mapper = new DynamoDBMapper(ddbClient);

        // ==============
        // END aws
    }

    public DynamoDBMapper getMapper() { return mapper; }
}
