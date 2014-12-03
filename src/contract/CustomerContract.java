/*
 * This class contains the methods that need to be implemented to connect 
    the frontend and backend of the ferry application.
 */

package contract;

import dto.*;
import eto.*;
import java.util.Collection;

/**
 *
 * @author Group F
 */
public interface CustomerContract {
    
    /**
     * Gets a complete timetable of ferry traffic according to the departure and destination port and departure time
     * @param trafficDetail the information necessary for finding relevant ferry trips
     * @return A collection of TrafficSummary
     * @throws InvalidRouteException if the route does not exist ,NoFerriesFoundException if ferries are not found on the route
     */
    public Collection<TrafficSummary> getTrafficInformation(TrafficDetail trafficDetail) throws InvalidRouteException,NoFerriesFoundException;
    
    /**
     * Sends all the information required for making a reservation to the frontend, for the users review
     * @param travelDetail 
     * @return TravelSummary an enriched set of data relevant for making the reservation
     * @throws NoScheduleException if the trip does not exist
     * @pre a ferry trip is selected
     * @post the reservation price is known
     */
    public TravelSummary getTravelSummary(TravelDetail travelDetail) throws NoScheduleException;
    
    /**
     * Makes a reservation after the user has approved all the details, including the price, of his travel
     * @param resDetail
     * @return a ReservationSummary relevant for showing a receipt to the client
     * @throws NoSuchReservationException
     * @pre a ferry trip is selected and the price is known
     * @post a reservation is created
     */
    public ReservationSummary makeReservation(ReservationDetail resDetail) throws NoSuchReservationException;
    
    /**
     * checks weather a user is a resident and entitled to special discounts
     * @return true or false depending on the user account
     * @pre user account must exist
     */
    public boolean isUserResident(AbstractAccount accDTO);
    
    /**
     * submits the necessary information to create a user account and returns a summary as confirmation
     * @param accDetail
     * @return AccountSummary for the users review
     * @throws InvalidAccountException if the information is incomplete or corrupted
     * @post a user account is created
     */
    public AccountSummary makeAccount(AccountDetail accDetail) throws InvalidAccountException;
    
    /**
     * 
     * @param email
     * @param password
     * @return the account corresponding to the user
     * @throws NoSuchAccountException 
     */
    public AccountDetail login(String email,String password) throws NoSuchAccountException;
}
