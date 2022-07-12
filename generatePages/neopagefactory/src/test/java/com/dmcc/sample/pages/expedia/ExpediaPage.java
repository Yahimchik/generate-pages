package com.dmcc.sample.pages.expedia;

import com.dmcc.pagegen.exceptions.PageException;
import com.dmcc.sample.pages.expedia.ExpediaField;
import com.dmcc.pagegen.page.mccarterp.McCarterPage;

public class ExpediaPage extends McCarterPage{

private final String url="https://www.expedia.co.uk";
private final String rRoot="./src/test/resources";

	public ExpediaPage navigate()throws PageException {
		this.setResourcesRoot(rRoot);
		this.navigate(url);
		return this;
	}

	public void clickFlightTypeRoundtripHpFlight()throws PageException{
		this.click(ExpediaField.FlightTypeRoundtripHpFlight);
	}

	public void clickFlightTypeOneWayHpFlight()throws PageException{
		this.click(ExpediaField.FlightTypeOneWayHpFlight);
	}

	public void clickFlightTypeMultiDestHpFlight()throws PageException{
		this.click(ExpediaField.FlightTypeMultiDestHpFlight);
	}

	public void clickAdvancedFlightNonstopHpFlight()throws PageException{
		this.click(ExpediaField.AdvancedFlightNonstopHpFlight);
	}

	public void clickAdvancedFlightRefundableHpFlight()throws PageException{
		this.click(ExpediaField.AdvancedFlightRefundableHpFlight);
	}

	public void clickNbsp()throws PageException{
		this.click(ExpediaField.Nbsp);
	}

	public void setSignupFirstName(final String value) throws PageException{
		this.setValue(ExpediaField.SignupFirstName, value);
	}

	public void clickSignupFirstName()throws PageException{
		this.click(ExpediaField.SignupFirstName);
	}

	public void setSignupLastName(final String value) throws PageException{
		this.setValue(ExpediaField.SignupLastName, value);
	}

	public void clickSignupLastName()throws PageException{
		this.click(ExpediaField.SignupLastName);
	}

	public void setSignupLoginid(final String value) throws PageException{
		this.setValue(ExpediaField.SignupLoginid, value);
	}

	public void clickSignupLoginid()throws PageException{
		this.click(ExpediaField.SignupLoginid);
	}

	public void setGssSignupPassword(final String value) throws PageException{
		this.setValue(ExpediaField.GssSignupPassword, value);
	}

	public void clickGssSignupPassword()throws PageException{
		this.click(ExpediaField.GssSignupPassword);
	}

	public void clickGssJoinProgramCheck()throws PageException{
		this.click(ExpediaField.GssJoinProgramCheck);
	}

	public void clickGssMarketingEmailOptInCheck()throws PageException{
		this.click(ExpediaField.GssMarketingEmailOptInCheck);
	}

	public void clickGssMarketingEmailOptDefaultValue()throws PageException{
		this.click(ExpediaField.GssMarketingEmailOptDefaultValue);
	}

	public void setSigninLoginid(final String value) throws PageException{
		this.setValue(ExpediaField.SigninLoginid, value);
	}

	public void clickSigninLoginid()throws PageException{
		this.click(ExpediaField.SigninLoginid);
	}

	public void setGssSigninPassword(final String value) throws PageException{
		this.setValue(ExpediaField.GssSigninPassword, value);
	}

	public void clickGssSigninPassword()throws PageException{
		this.click(ExpediaField.GssSigninPassword);
	}

	public void clickGssKeepSigninCheck()throws PageException{
		this.click(ExpediaField.GssKeepSigninCheck);
	}

	public void clickFlightType()throws PageException{
		this.click(ExpediaField.FlightType);
	}

	public void setFlightOriginHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.FlightOriginHpFlight, value);
	}

	public void clickFlightOriginHpFlight()throws PageException{
		this.click(ExpediaField.FlightOriginHpFlight);
	}

	public void setFlightDestinationHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.FlightDestinationHpFlight, value);
	}

	public void clickFlightDestinationHpFlight()throws PageException{
		this.click(ExpediaField.FlightDestinationHpFlight);
	}

	public void setStarDate(final String value) throws PageException{
		this.setValue(ExpediaField.StarDate, value);
	}

	public void clickStarDate()throws PageException{
		this.click(ExpediaField.StarDate);
	}

	public void setEndDate(final String value) throws PageException{
		this.setValue(ExpediaField.EndDate, value);
	}

	public void clickEndDate()throws PageException{
		this.click(ExpediaField.EndDate);
	}

	public void setFlight2OriginHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.Flight2OriginHpFlight, value);
	}

	public void clickFlight2OriginHpFlight()throws PageException{
		this.click(ExpediaField.Flight2OriginHpFlight);
	}

	public void setFlight2DestinationHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.Flight2DestinationHpFlight, value);
	}

	public void clickFlight2DestinationHpFlight()throws PageException{
		this.click(ExpediaField.Flight2DestinationHpFlight);
	}

	public void setFlight2DepartingHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.Flight2DepartingHpFlight, value);
	}

	public void clickFlight2DepartingHpFlight()throws PageException{
		this.click(ExpediaField.Flight2DepartingHpFlight);
	}

	public void clickLapOrSeat()throws PageException{
		this.click(ExpediaField.LapOrSeat);
	}

	public void clickAddHotel()throws PageException{
		this.click(ExpediaField.AddHotel);
	}

	public void clickAddCar()throws PageException{
		this.click(ExpediaField.AddCar);
	}

	public void setFlightHotelCheckinHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.FlightHotelCheckinHpFlight, value);
	}

	public void clickFlightHotelCheckinHpFlight()throws PageException{
		this.click(ExpediaField.FlightHotelCheckinHpFlight);
	}

	public void setFlightHotelCheckoutHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.FlightHotelCheckoutHpFlight, value);
	}

	public void clickFlightHotelCheckoutHpFlight()throws PageException{
		this.click(ExpediaField.FlightHotelCheckoutHpFlight);
	}

	public void clickDriverAgeCheckboxHpFlight()throws PageException{
		this.click(ExpediaField.DriverAgeCheckboxHpFlight);
	}

	public void setAge(final String value) throws PageException{
		this.setValue(ExpediaField.Age, value);
	}

	public void clickAge()throws PageException{
		this.click(ExpediaField.Age);
	}

	public void clickDirect()throws PageException{
		this.click(ExpediaField.Direct);
	}

	public void setDestination(final String value) throws PageException{
		this.setValue(ExpediaField.Destination, value);
	}

	public void clickDestination()throws PageException{
		this.click(ExpediaField.Destination);
	}

	public void setStartDate(final String value) throws PageException{
		this.setValue(ExpediaField.StartDate, value);
	}

	public void clickStartDate()throws PageException{
		this.click(ExpediaField.StartDate);
	}

	public void clickHotelAddFlightCheckboxHpHotel()throws PageException{
		this.click(ExpediaField.HotelAddFlightCheckboxHpHotel);
	}

	public void clickPackageRatesCheckboxVariantHpHotel()throws PageException{
		this.click(ExpediaField.PackageRatesCheckboxVariantHpHotel);
	}

	public void setDcty(final String value) throws PageException{
		this.setValue(ExpediaField.Dcty, value);
	}

	public void clickDcty()throws PageException{
		this.click(ExpediaField.Dcty);
	}

	public void clickDriverAgeCheckboxHpHotel()throws PageException{
		this.click(ExpediaField.DriverAgeCheckboxHpHotel);
	}

	public void clickPackageType()throws PageException{
		this.click(ExpediaField.PackageType);
	}

	public void setPackageOriginHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageOriginHpPackage, value);
	}

	public void clickPackageOriginHpPackage()throws PageException{
		this.click(ExpediaField.PackageOriginHpPackage);
	}

	public void setPackageDestinationHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageDestinationHpPackage, value);
	}

	public void clickPackageDestinationHpPackage()throws PageException{
		this.click(ExpediaField.PackageDestinationHpPackage);
	}

	public void setPackageOriginFCHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageOriginFCHpPackage, value);
	}

	public void clickPackageOriginFCHpPackage()throws PageException{
		this.click(ExpediaField.PackageOriginFCHpPackage);
	}

	public void setPackageDestinationFCHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageDestinationFCHpPackage, value);
	}

	public void clickPackageDestinationFCHpPackage()throws PageException{
		this.click(ExpediaField.PackageDestinationFCHpPackage);
	}

	public void setPackageDepartingHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageDepartingHpPackage, value);
	}

	public void clickPackageDepartingHpPackage()throws PageException{
		this.click(ExpediaField.PackageDepartingHpPackage);
	}

	public void setPackageReturningHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageReturningHpPackage, value);
	}

	public void clickPackageReturningHpPackage()throws PageException{
		this.click(ExpediaField.PackageReturningHpPackage);
	}

	public void setPackageFcDepartingHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageFcDepartingHpPackage, value);
	}

	public void clickPackageFcDepartingHpPackage()throws PageException{
		this.click(ExpediaField.PackageFcDepartingHpPackage);
	}

	public void setPackageFcReturningHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageFcReturningHpPackage, value);
	}

	public void clickPackageFcReturningHpPackage()throws PageException{
		this.click(ExpediaField.PackageFcReturningHpPackage);
	}

	public void setPackageHcDepartingHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageHcDepartingHpPackage, value);
	}

	public void clickPackageHcDepartingHpPackage()throws PageException{
		this.click(ExpediaField.PackageHcDepartingHpPackage);
	}

	public void setPackageHcReturningHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageHcReturningHpPackage, value);
	}

	public void clickPackageHcReturningHpPackage()throws PageException{
		this.click(ExpediaField.PackageHcReturningHpPackage);
	}

	public void clickPartialHotelBookingHpPackage()throws PageException{
		this.click(ExpediaField.PartialHotelBookingHpPackage);
	}

	public void setPackageCheckinHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageCheckinHpPackage, value);
	}

	public void clickPackageCheckinHpPackage()throws PageException{
		this.click(ExpediaField.PackageCheckinHpPackage);
	}

	public void setPackageCheckoutHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageCheckoutHpPackage, value);
	}

	public void clickPackageCheckoutHpPackage()throws PageException{
		this.click(ExpediaField.PackageCheckoutHpPackage);
	}

	public void clickDriverAgeCheckboxHpPackage()throws PageException{
		this.click(ExpediaField.DriverAgeCheckboxHpPackage);
	}

	public void clickPartialCarBookingHpPackage()throws PageException{
		this.click(ExpediaField.PartialCarBookingHpPackage);
	}

	public void setPackageCarPickupDateHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageCarPickupDateHpPackage, value);
	}

	public void clickPackageCarPickupDateHpPackage()throws PageException{
		this.click(ExpediaField.PackageCarPickupDateHpPackage);
	}

	public void setPackageCarDropoffDateHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageCarDropoffDateHpPackage, value);
	}

	public void clickPackageCarDropoffDateHpPackage()throws PageException{
		this.click(ExpediaField.PackageCarDropoffDateHpPackage);
	}

	public void setLocn(final String value) throws PageException{
		this.setValue(ExpediaField.Locn, value);
	}

	public void clickLocn()throws PageException{
		this.click(ExpediaField.Locn);
	}

	public void setLoc2(final String value) throws PageException{
		this.setValue(ExpediaField.Loc2, value);
	}

	public void clickLoc2()throws PageException{
		this.click(ExpediaField.Loc2);
	}

	public void setDate1(final String value) throws PageException{
		this.setValue(ExpediaField.Date1, value);
	}

	public void clickDate1()throws PageException{
		this.click(ExpediaField.Date1);
	}

	public void setDate2(final String value) throws PageException{
		this.setValue(ExpediaField.Date2, value);
	}

	public void clickDate2()throws PageException{
		this.click(ExpediaField.Date2);
	}

	public void clickDriverAgeCheckboxHpCar()throws PageException{
		this.click(ExpediaField.DriverAgeCheckboxHpCar);
	}

	public void setLocation(final String value) throws PageException{
		this.setValue(ExpediaField.Location, value);
	}

	public void clickLocation()throws PageException{
		this.click(ExpediaField.Location);
	}

	public void clickJourneyType()throws PageException{
		this.click(ExpediaField.JourneyType);
	}

	public void setOriginName(final String value) throws PageException{
		this.setValue(ExpediaField.OriginName, value);
	}

	public void clickOriginName()throws PageException{
		this.click(ExpediaField.OriginName);
	}

	public void setDestinationName(final String value) throws PageException{
		this.setValue(ExpediaField.DestinationName, value);
	}

	public void clickDestinationName()throws PageException{
		this.click(ExpediaField.DestinationName);
	}

	public void setSDate(final String value) throws PageException{
		this.setValue(ExpediaField.SDate, value);
	}

	public void clickSDate()throws PageException{
		this.click(ExpediaField.SDate);
	}

	public void setEDate(final String value) throws PageException{
		this.setValue(ExpediaField.EDate, value);
	}

	public void clickEDate()throws PageException{
		this.click(ExpediaField.EDate);
	}

	public void setMobileToggleHeaderLink(final String value) throws PageException{
		this.setValue(ExpediaField.MobileToggleHeaderLink, value);
	}

	public void clickMobileToggleHeaderLink()throws PageException{
		this.click(ExpediaField.MobileToggleHeaderLink);
	}

	public void clickAccountMenuIcon()throws PageException{
		this.click(ExpediaField.AccountMenuIcon);
	}

	public void clickHeaderAccountMenuSignin()throws PageException{
		this.click(ExpediaField.HeaderAccountMenuSignin);
	}

	public void setHeaderShopMenu(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderShopMenu, value);
	}

	public void clickHeaderShopMenu()throws PageException{
		this.click(ExpediaField.HeaderShopMenu);
	}

	public void clickHeaderAccountMenu()throws PageException{
		this.click(ExpediaField.HeaderAccountMenu);
	}

	public void clickHeaderAccountSigninButton()throws PageException{
		this.click(ExpediaField.HeaderAccountSigninButton);
	}

	public void clickHeaderAccountMenuSignedIn()throws PageException{
		this.click(ExpediaField.HeaderAccountMenuSignedIn);
	}

	public void clickHeaderTripMenu()throws PageException{
		this.click(ExpediaField.HeaderTripMenu);
	}

	public void clickHeaderSupportMenu()throws PageException{
		this.click(ExpediaField.HeaderSupportMenu);
	}

	public void clickGssSignupLoginFacebookButton()throws PageException{
		this.click(ExpediaField.GssSignupLoginFacebookButton);
	}

	public void clickGssSignupLoginGoogleButton()throws PageException{
		this.click(ExpediaField.GssSignupLoginGoogleButton);
	}

	public void clickGssSignupLoginNaverButton()throws PageException{
		this.click(ExpediaField.GssSignupLoginNaverButton);
	}

	public void clickGssSignupPasswordIconButton()throws PageException{
		this.click(ExpediaField.GssSignupPasswordIconButton);
	}

	public void clickGssSignupSubmit()throws PageException{
		this.click(ExpediaField.GssSignupSubmit);
	}

	public void clickGssGotoSignin()throws PageException{
		this.click(ExpediaField.GssGotoSignin);
	}

	public void clickGssSigninLoginFacebookButton()throws PageException{
		this.click(ExpediaField.GssSigninLoginFacebookButton);
	}

	public void clickGssSigninLoginGoogleButton()throws PageException{
		this.click(ExpediaField.GssSigninLoginGoogleButton);
	}

	public void clickGssSigninLoginNaverButton()throws PageException{
		this.click(ExpediaField.GssSigninLoginNaverButton);
	}

	public void clickGssSigninPasswordIconButton()throws PageException{
		this.click(ExpediaField.GssSigninPasswordIconButton);
	}

	public void clickGssSigninSubmit()throws PageException{
		this.click(ExpediaField.GssSigninSubmit);
	}

	public void clickGssGotoSignup()throws PageException{
		this.click(ExpediaField.GssGotoSignup);
	}

	public void clickTabFlightTabHp()throws PageException{
		this.click(ExpediaField.TabFlightTabHp);
	}

	public void clickTabHotelTabHp()throws PageException{
		this.click(ExpediaField.TabHotelTabHp);
	}

	public void clickTabPackageTabHp()throws PageException{
		this.click(ExpediaField.TabPackageTabHp);
	}

	public void clickTabCarTabHp()throws PageException{
		this.click(ExpediaField.TabCarTabHp);
	}

	public void clickTabActivityTabHp()throws PageException{
		this.click(ExpediaField.TabActivityTabHp);
	}

	public void clickTabRailTabHp()throws PageException{
		this.click(ExpediaField.TabRailTabHp);
	}

	public void clickTabVacationRentalTabHp()throws PageException{
		this.click(ExpediaField.TabVacationRentalTabHp);
	}

	public void clickSearchButtonHpPackage()throws PageException{
		this.click(ExpediaField.SearchButtonHpPackage);
	}

	public void setFlightAdultsHpFlight(final FlightAdultsHpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAdultsHpFlight, value.toString());
	}

	public void clickFlightAdultsHpFlight()throws PageException{
		this.click(ExpediaField.FlightAdultsHpFlight);
	}

	public void setFlightChildrenHpFlight(final FlightChildrenHpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightChildrenHpFlight, value.toString());
	}

	public void clickFlightChildrenHpFlight()throws PageException{
		this.click(ExpediaField.FlightChildrenHpFlight);
	}

	public void setFlightAgeSelect1HpFlight(final FlightAgeSelect1HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAgeSelect1HpFlight, value.toString());
	}

	public void clickFlightAgeSelect1HpFlight()throws PageException{
		this.click(ExpediaField.FlightAgeSelect1HpFlight);
	}

	public void setFlightAgeSelect2HpFlight(final FlightAgeSelect2HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAgeSelect2HpFlight, value.toString());
	}

	public void clickFlightAgeSelect2HpFlight()throws PageException{
		this.click(ExpediaField.FlightAgeSelect2HpFlight);
	}

	public void setFlightAgeSelect3HpFlight(final FlightAgeSelect3HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAgeSelect3HpFlight, value.toString());
	}

	public void clickFlightAgeSelect3HpFlight()throws PageException{
		this.click(ExpediaField.FlightAgeSelect3HpFlight);
	}

	public void setFlightAgeSelect4HpFlight(final FlightAgeSelect4HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAgeSelect4HpFlight, value.toString());
	}

	public void clickFlightAgeSelect4HpFlight()throws PageException{
		this.click(ExpediaField.FlightAgeSelect4HpFlight);
	}

	public void setFlightAgeSelect5HpFlight(final FlightAgeSelect5HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAgeSelect5HpFlight, value.toString());
	}

	public void clickFlightAgeSelect5HpFlight()throws PageException{
		this.click(ExpediaField.FlightAgeSelect5HpFlight);
	}

	public void setFlightAgeSelect6HpFlight(final FlightAgeSelect6HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAgeSelect6HpFlight, value.toString());
	}

	public void clickFlightAgeSelect6HpFlight()throws PageException{
		this.click(ExpediaField.FlightAgeSelect6HpFlight);
	}

	public void setFlightAdvancedPreferredAirlineHpFlight(final FlightAdvancedPreferredAirlineHpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAdvancedPreferredAirlineHpFlight, value.toString());
	}

	public void clickFlightAdvancedPreferredAirlineHpFlight()throws PageException{
		this.click(ExpediaField.FlightAdvancedPreferredAirlineHpFlight);
	}

	public void setFlightAdvancedPreferredClassHpFlight(final FlightAdvancedPreferredClassHpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightAdvancedPreferredClassHpFlight, value.toString());
	}

	public void clickFlightAdvancedPreferredClassHpFlight()throws PageException{
		this.click(ExpediaField.FlightAdvancedPreferredClassHpFlight);
	}

	public void setFlightHotelsRoomsHpFlight(final FlightHotelsRoomsHpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotelsRoomsHpFlight, value.toString());
	}

	public void clickFlightHotelsRoomsHpFlight()throws PageException{
		this.click(ExpediaField.FlightHotelsRoomsHpFlight);
	}

	public void setFlightHotel1AdultsHpFlight(final FlightHotel1AdultsHpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1AdultsHpFlight, value.toString());
	}

	public void clickFlightHotel1AdultsHpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1AdultsHpFlight);
	}

	public void setFlightHotel1ChildrenHpFlight(final FlightHotel1ChildrenHpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1ChildrenHpFlight, value.toString());
	}

	public void clickFlightHotel1ChildrenHpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1ChildrenHpFlight);
	}

	public void setFlightHotel1AgeSelect1HpFlight(final FlightHotel1AgeSelect1HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1AgeSelect1HpFlight, value.toString());
	}

	public void clickFlightHotel1AgeSelect1HpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1AgeSelect1HpFlight);
	}

	public void setFlightHotel1AgeSelect2HpFlight(final FlightHotel1AgeSelect2HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1AgeSelect2HpFlight, value.toString());
	}

	public void clickFlightHotel1AgeSelect2HpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1AgeSelect2HpFlight);
	}

	public void setFlightHotel1AgeSelect3HpFlight(final FlightHotel1AgeSelect3HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1AgeSelect3HpFlight, value.toString());
	}

	public void clickFlightHotel1AgeSelect3HpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1AgeSelect3HpFlight);
	}

	public void setFlightHotel1AgeSelect4HpFlight(final FlightHotel1AgeSelect4HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1AgeSelect4HpFlight, value.toString());
	}

	public void clickFlightHotel1AgeSelect4HpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1AgeSelect4HpFlight);
	}

	public void setFlightHotel1AgeSelect5HpFlight(final FlightHotel1AgeSelect5HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1AgeSelect5HpFlight, value.toString());
	}

	public void clickFlightHotel1AgeSelect5HpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1AgeSelect5HpFlight);
	}

	public void setFlightHotel1AgeSelect6HpFlight(final FlightHotel1AgeSelect6HpFlightEnum value) throws PageException{
		this.setValue(ExpediaField.FlightHotel1AgeSelect6HpFlight, value.toString());
	}

	public void clickFlightHotel1AgeSelect6HpFlight()throws PageException{
		this.click(ExpediaField.FlightHotel1AgeSelect6HpFlight);
	}

	public void setRooms(final RoomsEnum value) throws PageException{
		this.setValue(ExpediaField.Rooms, value.toString());
	}

	public void clickRooms()throws PageException{
		this.click(ExpediaField.Rooms);
	}

	public void setHotel1AdultsHpHotel(final Hotel1AdultsHpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1AdultsHpHotel, value.toString());
	}

	public void clickHotel1AdultsHpHotel()throws PageException{
		this.click(ExpediaField.Hotel1AdultsHpHotel);
	}

	public void setHotel1ChildrenHpHotel(final Hotel1ChildrenHpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1ChildrenHpHotel, value.toString());
	}

	public void clickHotel1ChildrenHpHotel()throws PageException{
		this.click(ExpediaField.Hotel1ChildrenHpHotel);
	}

	public void setHotel1AgeSelect1HpHotel(final Hotel1AgeSelect1HpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1AgeSelect1HpHotel, value.toString());
	}

	public void clickHotel1AgeSelect1HpHotel()throws PageException{
		this.click(ExpediaField.Hotel1AgeSelect1HpHotel);
	}

	public void setHotel1AgeSelect2HpHotel(final Hotel1AgeSelect2HpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1AgeSelect2HpHotel, value.toString());
	}

	public void clickHotel1AgeSelect2HpHotel()throws PageException{
		this.click(ExpediaField.Hotel1AgeSelect2HpHotel);
	}

	public void setHotel1AgeSelect3HpHotel(final Hotel1AgeSelect3HpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1AgeSelect3HpHotel, value.toString());
	}

	public void clickHotel1AgeSelect3HpHotel()throws PageException{
		this.click(ExpediaField.Hotel1AgeSelect3HpHotel);
	}

	public void setHotel1AgeSelect4HpHotel(final Hotel1AgeSelect4HpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1AgeSelect4HpHotel, value.toString());
	}

	public void clickHotel1AgeSelect4HpHotel()throws PageException{
		this.click(ExpediaField.Hotel1AgeSelect4HpHotel);
	}

	public void setHotel1AgeSelect5HpHotel(final Hotel1AgeSelect5HpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1AgeSelect5HpHotel, value.toString());
	}

	public void clickHotel1AgeSelect5HpHotel()throws PageException{
		this.click(ExpediaField.Hotel1AgeSelect5HpHotel);
	}

	public void setHotel1AgeSelect6HpHotel(final Hotel1AgeSelect6HpHotelEnum value) throws PageException{
		this.setValue(ExpediaField.Hotel1AgeSelect6HpHotel, value.toString());
	}

	public void clickHotel1AgeSelect6HpHotel()throws PageException{
		this.click(ExpediaField.Hotel1AgeSelect6HpHotel);
	}

	public void setPackageAdultsHpPackage(final PackageAdultsHpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAdultsHpPackage, value.toString());
	}

	public void clickPackageAdultsHpPackage()throws PageException{
		this.click(ExpediaField.PackageAdultsHpPackage);
	}

	public void setPackageChildrenHpPackage(final PackageChildrenHpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageChildrenHpPackage, value.toString());
	}

	public void clickPackageChildrenHpPackage()throws PageException{
		this.click(ExpediaField.PackageChildrenHpPackage);
	}

	public void setPackageAgeSelect1HpPackage(final PackageAgeSelect1HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAgeSelect1HpPackage, value.toString());
	}

	public void clickPackageAgeSelect1HpPackage()throws PageException{
		this.click(ExpediaField.PackageAgeSelect1HpPackage);
	}

	public void setPackageAgeSelect2HpPackage(final PackageAgeSelect2HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAgeSelect2HpPackage, value.toString());
	}

	public void clickPackageAgeSelect2HpPackage()throws PageException{
		this.click(ExpediaField.PackageAgeSelect2HpPackage);
	}

	public void setPackageAgeSelect3HpPackage(final PackageAgeSelect3HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAgeSelect3HpPackage, value.toString());
	}

	public void clickPackageAgeSelect3HpPackage()throws PageException{
		this.click(ExpediaField.PackageAgeSelect3HpPackage);
	}

	public void setPackageAgeSelect4HpPackage(final PackageAgeSelect4HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAgeSelect4HpPackage, value.toString());
	}

	public void clickPackageAgeSelect4HpPackage()throws PageException{
		this.click(ExpediaField.PackageAgeSelect4HpPackage);
	}

	public void setPackageAgeSelect5HpPackage(final PackageAgeSelect5HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAgeSelect5HpPackage, value.toString());
	}

	public void clickPackageAgeSelect5HpPackage()throws PageException{
		this.click(ExpediaField.PackageAgeSelect5HpPackage);
	}

	public void setPackageAgeSelect6HpPackage(final PackageAgeSelect6HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAgeSelect6HpPackage, value.toString());
	}

	public void clickPackageAgeSelect6HpPackage()throws PageException{
		this.click(ExpediaField.PackageAgeSelect6HpPackage);
	}

	public void setPackageRoomsHpPackage(final PackageRoomsHpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageRoomsHpPackage, value.toString());
	}

	public void clickPackageRoomsHpPackage()throws PageException{
		this.click(ExpediaField.PackageRoomsHpPackage);
	}

	public void setPackage1AdultsHpPackage(final Package1AdultsHpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1AdultsHpPackage, value.toString());
	}

	public void clickPackage1AdultsHpPackage()throws PageException{
		this.click(ExpediaField.Package1AdultsHpPackage);
	}

	public void setPackage1ChildrenHpPackage(final Package1ChildrenHpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1ChildrenHpPackage, value.toString());
	}

	public void clickPackage1ChildrenHpPackage()throws PageException{
		this.click(ExpediaField.Package1ChildrenHpPackage);
	}

	public void setPackage1AgeSelect1HpPackage(final Package1AgeSelect1HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1AgeSelect1HpPackage, value.toString());
	}

	public void clickPackage1AgeSelect1HpPackage()throws PageException{
		this.click(ExpediaField.Package1AgeSelect1HpPackage);
	}

	public void setPackage1AgeSelect2HpPackage(final Package1AgeSelect2HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1AgeSelect2HpPackage, value.toString());
	}

	public void clickPackage1AgeSelect2HpPackage()throws PageException{
		this.click(ExpediaField.Package1AgeSelect2HpPackage);
	}

	public void setPackage1AgeSelect3HpPackage(final Package1AgeSelect3HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1AgeSelect3HpPackage, value.toString());
	}

	public void clickPackage1AgeSelect3HpPackage()throws PageException{
		this.click(ExpediaField.Package1AgeSelect3HpPackage);
	}

	public void setPackage1AgeSelect4HpPackage(final Package1AgeSelect4HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1AgeSelect4HpPackage, value.toString());
	}

	public void clickPackage1AgeSelect4HpPackage()throws PageException{
		this.click(ExpediaField.Package1AgeSelect4HpPackage);
	}

	public void setPackage1AgeSelect5HpPackage(final Package1AgeSelect5HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1AgeSelect5HpPackage, value.toString());
	}

	public void clickPackage1AgeSelect5HpPackage()throws PageException{
		this.click(ExpediaField.Package1AgeSelect5HpPackage);
	}

	public void setPackage1AgeSelect6HpPackage(final Package1AgeSelect6HpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.Package1AgeSelect6HpPackage, value.toString());
	}

	public void clickPackage1AgeSelect6HpPackage()throws PageException{
		this.click(ExpediaField.Package1AgeSelect6HpPackage);
	}

	public void setPackageAdvancedPreferredClassHpPackage(final PackageAdvancedPreferredClassHpPackageEnum value) throws PageException{
		this.setValue(ExpediaField.PackageAdvancedPreferredClassHpPackage, value.toString());
	}

	public void clickPackageAdvancedPreferredClassHpPackage()throws PageException{
		this.click(ExpediaField.PackageAdvancedPreferredClassHpPackage);
	}

	public void setTime1(final Time1Enum value) throws PageException{
		this.setValue(ExpediaField.Time1, value.toString());
	}

	public void clickTime1()throws PageException{
		this.click(ExpediaField.Time1);
	}

	public void setTime2(final Time2Enum value) throws PageException{
		this.setValue(ExpediaField.Time2, value.toString());
	}

	public void clickTime2()throws PageException{
		this.click(ExpediaField.Time2);
	}

	public void setKind(final KindEnum value) throws PageException{
		this.setValue(ExpediaField.Kind, value.toString());
	}

	public void clickKind()throws PageException{
		this.click(ExpediaField.Kind);
	}

	public void setSearchBy(final SearchByEnum value) throws PageException{
		this.setValue(ExpediaField.SearchBy, value.toString());
	}

	public void clickSearchBy()throws PageException{
		this.click(ExpediaField.SearchBy);
	}

	public void setSTime(final STimeEnum value) throws PageException{
		this.setValue(ExpediaField.STime, value.toString());
	}

	public void clickSTime()throws PageException{
		this.click(ExpediaField.STime);
	}

	public void setRetSearchBy(final RetSearchByEnum value) throws PageException{
		this.setValue(ExpediaField.RetSearchBy, value.toString());
	}

	public void clickRetSearchBy()throws PageException{
		this.click(ExpediaField.RetSearchBy);
	}

	public void setETime(final ETimeEnum value) throws PageException{
		this.setValue(ExpediaField.ETime, value.toString());
	}

	public void clickETime()throws PageException{
		this.click(ExpediaField.ETime);
	}

	public void setRailAdultsHpRail(final RailAdultsHpRailEnum value) throws PageException{
		this.setValue(ExpediaField.RailAdultsHpRail, value.toString());
	}

	public void clickRailAdultsHpRail()throws PageException{
		this.click(ExpediaField.RailAdultsHpRail);
	}

	public void setChildAgesHpRail(final ChildAgesHpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildAgesHpRail, value.toString());
	}

	public void clickChildAgesHpRail()throws PageException{
		this.click(ExpediaField.ChildAgesHpRail);
	}

	public void setYouthAgesHpRail(final YouthAgesHpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthAgesHpRail, value.toString());
	}

	public void clickYouthAgesHpRail()throws PageException{
		this.click(ExpediaField.YouthAgesHpRail);
	}

	public void setSeniorAgesHpRail(final SeniorAgesHpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorAgesHpRail, value.toString());
	}

	public void clickSeniorAgesHpRail()throws PageException{
		this.click(ExpediaField.SeniorAgesHpRail);
	}

	public void setChildrenAgeSelect0HpRail(final ChildrenAgeSelect0HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect0HpRail, value.toString());
	}

	public void clickChildrenAgeSelect0HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect0HpRail);
	}

	public void setChildrenAgeSelect1HpRail(final ChildrenAgeSelect1HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect1HpRail, value.toString());
	}

	public void clickChildrenAgeSelect1HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect1HpRail);
	}

	public void setChildrenAgeSelect2HpRail(final ChildrenAgeSelect2HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect2HpRail, value.toString());
	}

	public void clickChildrenAgeSelect2HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect2HpRail);
	}

	public void setChildrenAgeSelect3HpRail(final ChildrenAgeSelect3HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect3HpRail, value.toString());
	}

	public void clickChildrenAgeSelect3HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect3HpRail);
	}

	public void setChildrenAgeSelect4HpRail(final ChildrenAgeSelect4HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect4HpRail, value.toString());
	}

	public void clickChildrenAgeSelect4HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect4HpRail);
	}

	public void setChildrenAgeSelect5HpRail(final ChildrenAgeSelect5HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect5HpRail, value.toString());
	}

	public void clickChildrenAgeSelect5HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect5HpRail);
	}

	public void setChildrenAgeSelect6HpRail(final ChildrenAgeSelect6HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect6HpRail, value.toString());
	}

	public void clickChildrenAgeSelect6HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect6HpRail);
	}

	public void setChildrenAgeSelect7HpRail(final ChildrenAgeSelect7HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect7HpRail, value.toString());
	}

	public void clickChildrenAgeSelect7HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect7HpRail);
	}

	public void setChildrenAgeSelect8HpRail(final ChildrenAgeSelect8HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.ChildrenAgeSelect8HpRail, value.toString());
	}

	public void clickChildrenAgeSelect8HpRail()throws PageException{
		this.click(ExpediaField.ChildrenAgeSelect8HpRail);
	}

	public void setYouthsAgeSelect0HpRail(final YouthsAgeSelect0HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect0HpRail, value.toString());
	}

	public void clickYouthsAgeSelect0HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect0HpRail);
	}

	public void setYouthsAgeSelect1HpRail(final YouthsAgeSelect1HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect1HpRail, value.toString());
	}

	public void clickYouthsAgeSelect1HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect1HpRail);
	}

	public void setYouthsAgeSelect2HpRail(final YouthsAgeSelect2HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect2HpRail, value.toString());
	}

	public void clickYouthsAgeSelect2HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect2HpRail);
	}

	public void setYouthsAgeSelect3HpRail(final YouthsAgeSelect3HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect3HpRail, value.toString());
	}

	public void clickYouthsAgeSelect3HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect3HpRail);
	}

	public void setYouthsAgeSelect4HpRail(final YouthsAgeSelect4HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect4HpRail, value.toString());
	}

	public void clickYouthsAgeSelect4HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect4HpRail);
	}

	public void setYouthsAgeSelect5HpRail(final YouthsAgeSelect5HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect5HpRail, value.toString());
	}

	public void clickYouthsAgeSelect5HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect5HpRail);
	}

	public void setYouthsAgeSelect6HpRail(final YouthsAgeSelect6HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect6HpRail, value.toString());
	}

	public void clickYouthsAgeSelect6HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect6HpRail);
	}

	public void setYouthsAgeSelect7HpRail(final YouthsAgeSelect7HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect7HpRail, value.toString());
	}

	public void clickYouthsAgeSelect7HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect7HpRail);
	}

	public void setYouthsAgeSelect8HpRail(final YouthsAgeSelect8HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.YouthsAgeSelect8HpRail, value.toString());
	}

	public void clickYouthsAgeSelect8HpRail()throws PageException{
		this.click(ExpediaField.YouthsAgeSelect8HpRail);
	}

	public void setSeniorsAgeSelect0HpRail(final SeniorsAgeSelect0HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect0HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect0HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect0HpRail);
	}

	public void setSeniorsAgeSelect1HpRail(final SeniorsAgeSelect1HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect1HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect1HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect1HpRail);
	}

	public void setSeniorsAgeSelect2HpRail(final SeniorsAgeSelect2HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect2HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect2HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect2HpRail);
	}

	public void setSeniorsAgeSelect3HpRail(final SeniorsAgeSelect3HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect3HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect3HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect3HpRail);
	}

	public void setSeniorsAgeSelect4HpRail(final SeniorsAgeSelect4HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect4HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect4HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect4HpRail);
	}

	public void setSeniorsAgeSelect5HpRail(final SeniorsAgeSelect5HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect5HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect5HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect5HpRail);
	}

	public void setSeniorsAgeSelect6HpRail(final SeniorsAgeSelect6HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect6HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect6HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect6HpRail);
	}

	public void setSeniorsAgeSelect7HpRail(final SeniorsAgeSelect7HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect7HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect7HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect7HpRail);
	}

	public void setSeniorsAgeSelect8HpRail(final SeniorsAgeSelect8HpRailEnum value) throws PageException{
		this.setValue(ExpediaField.SeniorsAgeSelect8HpRail, value.toString());
	}

	public void clickSeniorsAgeSelect8HpRail()throws PageException{
		this.click(ExpediaField.SeniorsAgeSelect8HpRail);
	}

	public void setRail(final RailEnum value) throws PageException{
		this.setValue(ExpediaField.Rail, value.toString());
	}

	public void clickRail()throws PageException{
		this.click(ExpediaField.Rail);
	}

	public void setAdults(final AdultsEnum value) throws PageException{
		this.setValue(ExpediaField.Adults, value.toString());
	}

	public void clickAdults()throws PageException{
		this.click(ExpediaField.Adults);
	}

	public void setSkipToMainContent(final String value) throws PageException{
		this.setValue(ExpediaField.SkipToMainContent, value);
	}

	public void clickSkipToMainContent()throws PageException{
		this.click(ExpediaField.SkipToMainContent);
	}

	public void setDone(final String value) throws PageException{
		this.setValue(ExpediaField.Done, value);
	}

	public void clickDone()throws PageException{
		this.click(ExpediaField.Done);
	}

	public void setJoinExpediaRewards(final String value) throws PageException{
		this.setValue(ExpediaField.JoinExpediaRewards, value);
	}

	public void clickJoinExpediaRewards()throws PageException{
		this.click(ExpediaField.JoinExpediaRewards);
	}

	public void setCreateAn0Account(final String value) throws PageException{
		this.setValue(ExpediaField.CreateAn0Account, value);
	}

	public void clickCreateAn0Account()throws PageException{
		this.click(ExpediaField.CreateAn0Account);
	}

	public void setMyAccount(final String value) throws PageException{
		this.setValue(ExpediaField.MyAccount, value);
	}

	public void clickMyAccount()throws PageException{
		this.click(ExpediaField.MyAccount);
	}

	public void setMyTrips(final String value) throws PageException{
		this.setValue(ExpediaField.MyTrips, value);
	}

	public void clickMyTrips()throws PageException{
		this.click(ExpediaField.MyTrips);
	}

	public void setMyRewards(final String value) throws PageException{
		this.setValue(ExpediaField.MyRewards, value);
	}

	public void clickMyRewards()throws PageException{
		this.click(ExpediaField.MyRewards);
	}

	public void setSignOut(final String value) throws PageException{
		this.setValue(ExpediaField.SignOut, value);
	}

	public void clickSignOut()throws PageException{
		this.click(ExpediaField.SignOut);
	}

	public void setHome(final String value) throws PageException{
		this.setValue(ExpediaField.Home, value);
	}

	public void clickHome()throws PageException{
		this.click(ExpediaField.Home);
	}

	public void setHotels(final String value) throws PageException{
		this.setValue(ExpediaField.Hotels, value);
	}

	public void clickHotels()throws PageException{
		this.click(ExpediaField.Hotels);
	}

	public void setFlights(final String value) throws PageException{
		this.setValue(ExpediaField.Flights, value);
	}

	public void clickFlights()throws PageException{
		this.click(ExpediaField.Flights);
	}

	public void setFlightHotel(final String value) throws PageException{
		this.setValue(ExpediaField.FlightHotel, value);
	}

	public void clickFlightHotel()throws PageException{
		this.click(ExpediaField.FlightHotel);
	}

	public void setCar(final String value) throws PageException{
		this.setValue(ExpediaField.Car, value);
	}

	public void clickCar()throws PageException{
		this.click(ExpediaField.Car);
	}

	public void setTrains(final String value) throws PageException{
		this.setValue(ExpediaField.Trains, value);
	}

	public void clickTrains()throws PageException{
		this.click(ExpediaField.Trains);
	}

	public void setHolidayRentals(final String value) throws PageException{
		this.setValue(ExpediaField.HolidayRentals, value);
	}

	public void clickHolidayRentals()throws PageException{
		this.click(ExpediaField.HolidayRentals);
	}

	public void setThingsToDo(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDo, value);
	}

	public void clickThingsToDo()throws PageException{
		this.click(ExpediaField.ThingsToDo);
	}

	public void setLastMinute(final String value) throws PageException{
		this.setValue(ExpediaField.LastMinute, value);
	}

	public void clickLastMinute()throws PageException{
		this.click(ExpediaField.LastMinute);
	}

	public void setBeach(final String value) throws PageException{
		this.setValue(ExpediaField.Beach, value);
	}

	public void clickBeach()throws PageException{
		this.click(ExpediaField.Beach);
	}

	public void setDeals(final String value) throws PageException{
		this.setValue(ExpediaField.Deals, value);
	}

	public void clickDeals()throws PageException{
		this.click(ExpediaField.Deals);
	}

	public void setCityBreaks(final String value) throws PageException{
		this.setValue(ExpediaField.CityBreaks, value);
	}

	public void clickCityBreaks()throws PageException{
		this.click(ExpediaField.CityBreaks);
	}

	public void setRewards(final String value) throws PageException{
		this.setValue(ExpediaField.Rewards, value);
	}

	public void clickRewards()throws PageException{
		this.click(ExpediaField.Rewards);
	}

	public void setAddYourProperty(final String value) throws PageException{
		this.setValue(ExpediaField.AddYourProperty, value);
	}

	public void clickAddYourProperty()throws PageException{
		this.click(ExpediaField.AddYourProperty);
	}

	public void setItineraries(final String value) throws PageException{
		this.setValue(ExpediaField.Itineraries, value);
	}

	public void clickItineraries()throws PageException{
		this.click(ExpediaField.Itineraries);
	}

	public void setTravellersTools(final String value) throws PageException{
		this.setValue(ExpediaField.TravellersTools, value);
	}

	public void clickTravellersTools()throws PageException{
		this.click(ExpediaField.TravellersTools);
	}

	public void setManageMyFlight(final String value) throws PageException{
		this.setValue(ExpediaField.ManageMyFlight, value);
	}

	public void clickManageMyFlight()throws PageException{
		this.click(ExpediaField.ManageMyFlight);
	}

	public void setManageMyHotel(final String value) throws PageException{
		this.setValue(ExpediaField.ManageMyHotel, value);
	}

	public void clickManageMyHotel()throws PageException{
		this.click(ExpediaField.ManageMyHotel);
	}

	public void setVisasPassports(final String value) throws PageException{
		this.setValue(ExpediaField.VisasPassports, value);
	}

	public void clickVisasPassports()throws PageException{
		this.click(ExpediaField.VisasPassports);
	}

	public void setCustomerSupport(final String value) throws PageException{
		this.setValue(ExpediaField.CustomerSupport, value);
	}

	public void clickCustomerSupport()throws PageException{
		this.click(ExpediaField.CustomerSupport);
	}

	public void setFeedback(final String value) throws PageException{
		this.setValue(ExpediaField.Feedback, value);
	}

	public void clickFeedback()throws PageException{
		this.click(ExpediaField.Feedback);
	}

	public void setForgotPassword(final String value) throws PageException{
		this.setValue(ExpediaField.ForgotPassword, value);
	}

	public void clickForgotPassword()throws PageException{
		this.click(ExpediaField.ForgotPassword);
	}

	public void setExpediaRewards(final String value) throws PageException{
		this.setValue(ExpediaField.ExpediaRewards, value);
	}

	public void clickExpediaRewards()throws PageException{
		this.click(ExpediaField.ExpediaRewards);
	}

	public void setTermsAndConditions(final String value) throws PageException{
		this.setValue(ExpediaField.TermsAndConditions, value);
	}

	public void clickTermsAndConditions()throws PageException{
		this.click(ExpediaField.TermsAndConditions);
	}

	public void setTermsApply(final String value) throws PageException{
		this.setValue(ExpediaField.TermsApply, value);
	}

	public void clickTermsApply()throws PageException{
		this.click(ExpediaField.TermsApply);
	}

	public void setAddYourHotelToExpedia(final String value) throws PageException{
		this.setValue(ExpediaField.AddYourHotelToExpedia, value);
	}

	public void clickAddYourHotelToExpedia()throws PageException{
		this.click(ExpediaField.AddYourHotelToExpedia);
	}

	public void setHotel(final String value) throws PageException{
		this.setValue(ExpediaField.Hotel, value);
	}

	public void clickHotel()throws PageException{
		this.click(ExpediaField.Hotel);
	}

	public void setBeachHoliday(final String value) throws PageException{
		this.setValue(ExpediaField.BeachHoliday, value);
	}

	public void clickBeachHoliday()throws PageException{
		this.click(ExpediaField.BeachHoliday);
	}

	public void setCityBreak(final String value) throws PageException{
		this.setValue(ExpediaField.CityBreak, value);
	}

	public void clickCityBreak()throws PageException{
		this.click(ExpediaField.CityBreak);
	}

	public void setNewYorkHotels(final String value) throws PageException{
		this.setValue(ExpediaField.NewYorkHotels, value);
	}

	public void clickNewYorkHotels()throws PageException{
		this.click(ExpediaField.NewYorkHotels);
	}

	public void setParisHotels(final String value) throws PageException{
		this.setValue(ExpediaField.ParisHotels, value);
	}

	public void clickParisHotels()throws PageException{
		this.click(ExpediaField.ParisHotels);
	}

	public void setLasVegasHotels(final String value) throws PageException{
		this.setValue(ExpediaField.LasVegasHotels, value);
	}

	public void clickLasVegasHotels()throws PageException{
		this.click(ExpediaField.LasVegasHotels);
	}

	public void setRomeHotels(final String value) throws PageException{
		this.setValue(ExpediaField.RomeHotels, value);
	}

	public void clickRomeHotels()throws PageException{
		this.click(ExpediaField.RomeHotels);
	}

	public void setBarcelonaHotels(final String value) throws PageException{
		this.setValue(ExpediaField.BarcelonaHotels, value);
	}

	public void clickBarcelonaHotels()throws PageException{
		this.click(ExpediaField.BarcelonaHotels);
	}

	public void setAmsterdamHotels(final String value) throws PageException{
		this.setValue(ExpediaField.AmsterdamHotels, value);
	}

	public void clickAmsterdamHotels()throws PageException{
		this.click(ExpediaField.AmsterdamHotels);
	}

	public void setDubaiHotels(final String value) throws PageException{
		this.setValue(ExpediaField.DubaiHotels, value);
	}

	public void clickDubaiHotels()throws PageException{
		this.click(ExpediaField.DubaiHotels);
	}

	public void setBerlinHotels(final String value) throws PageException{
		this.setValue(ExpediaField.BerlinHotels, value);
	}

	public void clickBerlinHotels()throws PageException{
		this.click(ExpediaField.BerlinHotels);
	}

	public void setTenerifeHotels(final String value) throws PageException{
		this.setValue(ExpediaField.TenerifeHotels, value);
	}

	public void clickTenerifeHotels()throws PageException{
		this.click(ExpediaField.TenerifeHotels);
	}

	public void setAlgarveHotels(final String value) throws PageException{
		this.setValue(ExpediaField.AlgarveHotels, value);
	}

	public void clickAlgarveHotels()throws PageException{
		this.click(ExpediaField.AlgarveHotels);
	}

	public void setMallorcaIslandHotels(final String value) throws PageException{
		this.setValue(ExpediaField.MallorcaIslandHotels, value);
	}

	public void clickMallorcaIslandHotels()throws PageException{
		this.click(ExpediaField.MallorcaIslandHotels);
	}

	public void setVeniceHotels(final String value) throws PageException{
		this.setValue(ExpediaField.VeniceHotels, value);
	}

	public void clickVeniceHotels()throws PageException{
		this.click(ExpediaField.VeniceHotels);
	}

	public void setPragueHotels(final String value) throws PageException{
		this.setValue(ExpediaField.PragueHotels, value);
	}

	public void clickPragueHotels()throws PageException{
		this.click(ExpediaField.PragueHotels);
	}

	public void setFlorenceHotels(final String value) throws PageException{
		this.setValue(ExpediaField.FlorenceHotels, value);
	}

	public void clickFlorenceHotels()throws PageException{
		this.click(ExpediaField.FlorenceHotels);
	}

	public void setLanzaroteHotels(final String value) throws PageException{
		this.setValue(ExpediaField.LanzaroteHotels, value);
	}

	public void clickLanzaroteHotels()throws PageException{
		this.click(ExpediaField.LanzaroteHotels);
	}

	public void setHotelsInTheUKIreland(final String value) throws PageException{
		this.setValue(ExpediaField.HotelsInTheUKIreland, value);
	}

	public void clickHotelsInTheUKIreland()throws PageException{
		this.click(ExpediaField.HotelsInTheUKIreland);
	}

	public void setHotelInLondon(final String value) throws PageException{
		this.setValue(ExpediaField.HotelInLondon, value);
	}

	public void clickHotelInLondon()throws PageException{
		this.click(ExpediaField.HotelInLondon);
	}

	public void setLakeDistrictHotel(final String value) throws PageException{
		this.setValue(ExpediaField.LakeDistrictHotel, value);
	}

	public void clickLakeDistrictHotel()throws PageException{
		this.click(ExpediaField.LakeDistrictHotel);
	}

	public void setStayInDublin(final String value) throws PageException{
		this.setValue(ExpediaField.StayInDublin, value);
	}

	public void clickStayInDublin()throws PageException{
		this.click(ExpediaField.StayInDublin);
	}

	public void setLondonHotels(final String value) throws PageException{
		this.setValue(ExpediaField.LondonHotels, value);
	}

	public void clickLondonHotels()throws PageException{
		this.click(ExpediaField.LondonHotels);
	}

	public void setEdinburghHotels(final String value) throws PageException{
		this.setValue(ExpediaField.EdinburghHotels, value);
	}

	public void clickEdinburghHotels()throws PageException{
		this.click(ExpediaField.EdinburghHotels);
	}

	public void setDublinHotels(final String value) throws PageException{
		this.setValue(ExpediaField.DublinHotels, value);
	}

	public void clickDublinHotels()throws PageException{
		this.click(ExpediaField.DublinHotels);
	}

	public void setManchesterHotels(final String value) throws PageException{
		this.setValue(ExpediaField.ManchesterHotels, value);
	}

	public void clickManchesterHotels()throws PageException{
		this.click(ExpediaField.ManchesterHotels);
	}

	public void setBirminghamHotels(final String value) throws PageException{
		this.setValue(ExpediaField.BirminghamHotels, value);
	}

	public void clickBirminghamHotels()throws PageException{
		this.click(ExpediaField.BirminghamHotels);
	}

	public void setYorkHotels(final String value) throws PageException{
		this.setValue(ExpediaField.YorkHotels, value);
	}

	public void clickYorkHotels()throws PageException{
		this.click(ExpediaField.YorkHotels);
	}

	public void setGlasgowHotels(final String value) throws PageException{
		this.setValue(ExpediaField.GlasgowHotels, value);
	}

	public void clickGlasgowHotels()throws PageException{
		this.click(ExpediaField.GlasgowHotels);
	}

	public void setDevonHotels(final String value) throws PageException{
		this.setValue(ExpediaField.DevonHotels, value);
	}

	public void clickDevonHotels()throws PageException{
		this.click(ExpediaField.DevonHotels);
	}

	public void setLiverpoolHotels(final String value) throws PageException{
		this.setValue(ExpediaField.LiverpoolHotels, value);
	}

	public void clickLiverpoolHotels()throws PageException{
		this.click(ExpediaField.LiverpoolHotels);
	}

	public void setBristolHotels(final String value) throws PageException{
		this.setValue(ExpediaField.BristolHotels, value);
	}

	public void clickBristolHotels()throws PageException{
		this.click(ExpediaField.BristolHotels);
	}

	public void setNewcastleUponTyneHotels(final String value) throws PageException{
		this.setValue(ExpediaField.NewcastleUponTyneHotels, value);
	}

	public void clickNewcastleUponTyneHotels()throws PageException{
		this.click(ExpediaField.NewcastleUponTyneHotels);
	}

	public void setBlackpoolHotels(final String value) throws PageException{
		this.setValue(ExpediaField.BlackpoolHotels, value);
	}

	public void clickBlackpoolHotels()throws PageException{
		this.click(ExpediaField.BlackpoolHotels);
	}

	public void setCardiffHotels(final String value) throws PageException{
		this.setValue(ExpediaField.CardiffHotels, value);
	}

	public void clickCardiffHotels()throws PageException{
		this.click(ExpediaField.CardiffHotels);
	}

	public void setBrightonHotels(final String value) throws PageException{
		this.setValue(ExpediaField.BrightonHotels, value);
	}

	public void clickBrightonHotels()throws PageException{
		this.click(ExpediaField.BrightonHotels);
	}

	public void setChesterHotels(final String value) throws PageException{
		this.setValue(ExpediaField.ChesterHotels, value);
	}

	public void clickChesterHotels()throws PageException{
		this.click(ExpediaField.ChesterHotels);
	}

	public void setParkPlazaWestminsterBridgeLondon(final String value) throws PageException{
		this.setValue(ExpediaField.ParkPlazaWestminsterBridgeLondon, value);
	}

	public void clickParkPlazaWestminsterBridgeLondon()throws PageException{
		this.click(ExpediaField.ParkPlazaWestminsterBridgeLondon);
	}

	public void setShangriLaHotelAtTheShardLondon(final String value) throws PageException{
		this.setValue(ExpediaField.ShangriLaHotelAtTheShardLondon, value);
	}

	public void clickShangriLaHotelAtTheShardLondon()throws PageException{
		this.click(ExpediaField.ShangriLaHotelAtTheShardLondon);
	}

	public void setInterContinentalLondonTheO2(final String value) throws PageException{
		this.setValue(ExpediaField.InterContinentalLondonTheO2, value);
	}

	public void clickInterContinentalLondonTheO2()throws PageException{
		this.click(ExpediaField.InterContinentalLondonTheO2);
	}

	public void setThePrincipalManchester(final String value) throws PageException{
		this.setValue(ExpediaField.ThePrincipalManchester, value);
	}

	public void clickThePrincipalManchester()throws PageException{
		this.click(ExpediaField.ThePrincipalManchester);
	}

	public void setTheAlexandraHotel(final String value) throws PageException{
		this.setValue(ExpediaField.TheAlexandraHotel, value);
	}

	public void clickTheAlexandraHotel()throws PageException{
		this.click(ExpediaField.TheAlexandraHotel);
	}

	public void setPrincessStHotel(final String value) throws PageException{
		this.setValue(ExpediaField.PrincessStHotel, value);
	}

	public void clickPrincessStHotel()throws PageException{
		this.click(ExpediaField.PrincessStHotel);
	}

	public void setLimeWood(final String value) throws PageException{
		this.setValue(ExpediaField.LimeWood, value);
	}

	public void clickLimeWood()throws PageException{
		this.click(ExpediaField.LimeWood);
	}

	public void setTitanicHotelLiverpool(final String value) throws PageException{
		this.setValue(ExpediaField.TitanicHotelLiverpool, value);
	}

	public void clickTitanicHotelLiverpool()throws PageException{
		this.click(ExpediaField.TitanicHotelLiverpool);
	}

	public void setCityCourtyardApartmentsAmpPenthouse(final String value) throws PageException{
		this.setValue(ExpediaField.CityCourtyardApartmentsAmpPenthouse, value);
	}

	public void clickCityCourtyardApartmentsAmpPenthouse()throws PageException{
		this.click(ExpediaField.CityCourtyardApartmentsAmpPenthouse);
	}

	public void setPeckfortonCastle(final String value) throws PageException{
		this.setValue(ExpediaField.PeckfortonCastle, value);
	}

	public void clickPeckfortonCastle()throws PageException{
		this.click(ExpediaField.PeckfortonCastle);
	}

	public void setRamsideHallHotelGolfAndSpa(final String value) throws PageException{
		this.setValue(ExpediaField.RamsideHallHotelGolfAndSpa, value);
	}

	public void clickRamsideHallHotelGolfAndSpa()throws PageException{
		this.click(ExpediaField.RamsideHallHotelGolfAndSpa);
	}

	public void setCrownePlazaLondonKingsCross(final String value) throws PageException{
		this.setValue(ExpediaField.CrownePlazaLondonKingsCross, value);
	}

	public void clickCrownePlazaLondonKingsCross()throws PageException{
		this.click(ExpediaField.CrownePlazaLondonKingsCross);
	}

	public void setStGilesLondonAStGilesHotel(final String value) throws PageException{
		this.setValue(ExpediaField.StGilesLondonAStGilesHotel, value);
	}

	public void clickStGilesLondonAStGilesHotel()throws PageException{
		this.click(ExpediaField.StGilesLondonAStGilesHotel);
	}

	public void setTheTowerHotel(final String value) throws PageException{
		this.setValue(ExpediaField.TheTowerHotel, value);
	}

	public void clickTheTowerHotel()throws PageException{
		this.click(ExpediaField.TheTowerHotel);
	}

	public void setAtlantisThePalm(final String value) throws PageException{
		this.setValue(ExpediaField.AtlantisThePalm, value);
	}

	public void clickAtlantisThePalm()throws PageException{
		this.click(ExpediaField.AtlantisThePalm);
	}

	public void setDanaVillas(final String value) throws PageException{
		this.setValue(ExpediaField.DanaVillas, value);
	}

	public void clickDanaVillas()throws PageException{
		this.click(ExpediaField.DanaVillas);
	}

	public void setTheGrandAtMoonPalace(final String value) throws PageException{
		this.setValue(ExpediaField.TheGrandAtMoonPalace, value);
	}

	public void clickTheGrandAtMoonPalace()throws PageException{
		this.click(ExpediaField.TheGrandAtMoonPalace);
	}

	public void setSunlightBahiaPrincipeTenerife(final String value) throws PageException{
		this.setValue(ExpediaField.SunlightBahiaPrincipeTenerife, value);
	}

	public void clickSunlightBahiaPrincipeTenerife()throws PageException{
		this.click(ExpediaField.SunlightBahiaPrincipeTenerife);
	}

	public void setMoonPalaceCancun(final String value) throws PageException{
		this.setValue(ExpediaField.MoonPalaceCancun, value);
	}

	public void clickMoonPalaceCancun()throws PageException{
		this.click(ExpediaField.MoonPalaceCancun);
	}

	public void setTheManhattanAtTimesSquareHotel(final String value) throws PageException{
		this.setValue(ExpediaField.TheManhattanAtTimesSquareHotel, value);
	}

	public void clickTheManhattanAtTimesSquareHotel()throws PageException{
		this.click(ExpediaField.TheManhattanAtTimesSquareHotel);
	}

	public void setGranCastilloTagoro(final String value) throws PageException{
		this.setValue(ExpediaField.GranCastilloTagoro, value);
	}

	public void clickGranCastilloTagoro()throws PageException{
		this.click(ExpediaField.GranCastilloTagoro);
	}

	public void setFIVEPalmJumeirahDubai(final String value) throws PageException{
		this.setValue(ExpediaField.FIVEPalmJumeirahDubai, value);
	}

	public void clickFIVEPalmJumeirahDubai()throws PageException{
		this.click(ExpediaField.FIVEPalmJumeirahDubai);
	}

	public void setSonevaJani(final String value) throws PageException{
		this.setValue(ExpediaField.SonevaJani, value);
	}

	public void clickSonevaJani()throws PageException{
		this.click(ExpediaField.SonevaJani);
	}

	public void setHardRockHotelTenerife(final String value) throws PageException{
		this.setValue(ExpediaField.HardRockHotelTenerife, value);
	}

	public void clickHardRockHotelTenerife()throws PageException{
		this.click(ExpediaField.HardRockHotelTenerife);
	}

	public void setTheCosmopolitanOfLasVegas(final String value) throws PageException{
		this.setValue(ExpediaField.TheCosmopolitanOfLasVegas, value);
	}

	public void clickTheCosmopolitanOfLasVegas()throws PageException{
		this.click(ExpediaField.TheCosmopolitanOfLasVegas);
	}

	public void setAquapetraResortAndSpa(final String value) throws PageException{
		this.setValue(ExpediaField.AquapetraResortAndSpa, value);
	}

	public void clickAquapetraResortAndSpa()throws PageException{
		this.click(ExpediaField.AquapetraResortAndSpa);
	}

	public void setHotelRiuPlazaTheGreshamDublin(final String value) throws PageException{
		this.setValue(ExpediaField.HotelRiuPlazaTheGreshamDublin, value);
	}

	public void clickHotelRiuPlazaTheGreshamDublin()throws PageException{
		this.click(ExpediaField.HotelRiuPlazaTheGreshamDublin);
	}

	public void setTheRooseveltHotelNewYorkCity(final String value) throws PageException{
		this.setValue(ExpediaField.TheRooseveltHotelNewYorkCity, value);
	}

	public void clickTheRooseveltHotelNewYorkCity()throws PageException{
		this.click(ExpediaField.TheRooseveltHotelNewYorkCity);
	}

	public void setHotelEdison(final String value) throws PageException{
		this.setValue(ExpediaField.HotelEdison, value);
	}

	public void clickHotelEdison()throws PageException{
		this.click(ExpediaField.HotelEdison);
	}

	public void setCheapFlightDeals(final String value) throws PageException{
		this.setValue(ExpediaField.CheapFlightDeals, value);
	}

	public void clickCheapFlightDeals()throws PageException{
		this.click(ExpediaField.CheapFlightDeals);
	}

	public void setParisFlights(final String value) throws PageException{
		this.setValue(ExpediaField.ParisFlights, value);
	}

	public void clickParisFlights()throws PageException{
		this.click(ExpediaField.ParisFlights);
	}

	public void setAmsterdamFlights(final String value) throws PageException{
		this.setValue(ExpediaField.AmsterdamFlights, value);
	}

	public void clickAmsterdamFlights()throws PageException{
		this.click(ExpediaField.AmsterdamFlights);
	}

	public void setDublinFlights(final String value) throws PageException{
		this.setValue(ExpediaField.DublinFlights, value);
	}

	public void clickDublinFlights()throws PageException{
		this.click(ExpediaField.DublinFlights);
	}

	public void setNewYorkFlights(final String value) throws PageException{
		this.setValue(ExpediaField.NewYorkFlights, value);
	}

	public void clickNewYorkFlights()throws PageException{
		this.click(ExpediaField.NewYorkFlights);
	}

	public void setRomeFlights(final String value) throws PageException{
		this.setValue(ExpediaField.RomeFlights, value);
	}

	public void clickRomeFlights()throws PageException{
		this.click(ExpediaField.RomeFlights);
	}

	public void setBarcelonaFlights(final String value) throws PageException{
		this.setValue(ExpediaField.BarcelonaFlights, value);
	}

	public void clickBarcelonaFlights()throws PageException{
		this.click(ExpediaField.BarcelonaFlights);
	}

	public void setBerlinFlights(final String value) throws PageException{
		this.setValue(ExpediaField.BerlinFlights, value);
	}

	public void clickBerlinFlights()throws PageException{
		this.click(ExpediaField.BerlinFlights);
	}

	public void setBangkokFlights(final String value) throws PageException{
		this.setValue(ExpediaField.BangkokFlights, value);
	}

	public void clickBangkokFlights()throws PageException{
		this.click(ExpediaField.BangkokFlights);
	}

	public void setMallorcaIslandFlights(final String value) throws PageException{
		this.setValue(ExpediaField.MallorcaIslandFlights, value);
	}

	public void clickMallorcaIslandFlights()throws PageException{
		this.click(ExpediaField.MallorcaIslandFlights);
	}

	public void setLasVegasFlights(final String value) throws PageException{
		this.setValue(ExpediaField.LasVegasFlights, value);
	}

	public void clickLasVegasFlights()throws PageException{
		this.click(ExpediaField.LasVegasFlights);
	}

	public void setMadridFlights(final String value) throws PageException{
		this.setValue(ExpediaField.MadridFlights, value);
	}

	public void clickMadridFlights()throws PageException{
		this.click(ExpediaField.MadridFlights);
	}

	public void setVeniceFlights(final String value) throws PageException{
		this.setValue(ExpediaField.VeniceFlights, value);
	}

	public void clickVeniceFlights()throws PageException{
		this.click(ExpediaField.VeniceFlights);
	}

	public void setLosAngelesFlights(final String value) throws PageException{
		this.setValue(ExpediaField.LosAngelesFlights, value);
	}

	public void clickLosAngelesFlights()throws PageException{
		this.click(ExpediaField.LosAngelesFlights);
	}

	public void setAlgarveFlights(final String value) throws PageException{
		this.setValue(ExpediaField.AlgarveFlights, value);
	}

	public void clickAlgarveFlights()throws PageException{
		this.click(ExpediaField.AlgarveFlights);
	}

	public void setLondonFlights(final String value) throws PageException{
		this.setValue(ExpediaField.LondonFlights, value);
	}

	public void clickLondonFlights()throws PageException{
		this.click(ExpediaField.LondonFlights);
	}

	public void setHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.Holidays, value);
	}

	public void clickHolidays()throws PageException{
		this.click(ExpediaField.Holidays);
	}

	public void setLastMinuteDeals(final String value) throws PageException{
		this.setValue(ExpediaField.LastMinuteDeals, value);
	}

	public void clickLastMinuteDeals()throws PageException{
		this.click(ExpediaField.LastMinuteDeals);
	}

	public void setNewYorkHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.NewYorkHolidays, value);
	}

	public void clickNewYorkHolidays()throws PageException{
		this.click(ExpediaField.NewYorkHolidays);
	}

	public void setDubaiHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.DubaiHolidays, value);
	}

	public void clickDubaiHolidays()throws PageException{
		this.click(ExpediaField.DubaiHolidays);
	}

	public void setAmsterdamHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.AmsterdamHolidays, value);
	}

	public void clickAmsterdamHolidays()throws PageException{
		this.click(ExpediaField.AmsterdamHolidays);
	}

	public void setParisHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.ParisHolidays, value);
	}

	public void clickParisHolidays()throws PageException{
		this.click(ExpediaField.ParisHolidays);
	}

	public void setLasVegasHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.LasVegasHolidays, value);
	}

	public void clickLasVegasHolidays()throws PageException{
		this.click(ExpediaField.LasVegasHolidays);
	}

	public void setOrlandoHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.OrlandoHolidays, value);
	}

	public void clickOrlandoHolidays()throws PageException{
		this.click(ExpediaField.OrlandoHolidays);
	}

	public void setBarcelonaHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.BarcelonaHolidays, value);
	}

	public void clickBarcelonaHolidays()throws PageException{
		this.click(ExpediaField.BarcelonaHolidays);
	}

	public void setVeniceHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.VeniceHolidays, value);
	}

	public void clickVeniceHolidays()throws PageException{
		this.click(ExpediaField.VeniceHolidays);
	}

	public void setDublinHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.DublinHolidays, value);
	}

	public void clickDublinHolidays()throws PageException{
		this.click(ExpediaField.DublinHolidays);
	}

	public void setBoraBoraHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.BoraBoraHolidays, value);
	}

	public void clickBoraBoraHolidays()throws PageException{
		this.click(ExpediaField.BoraBoraHolidays);
	}

	public void setBaliHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.BaliHolidays, value);
	}

	public void clickBaliHolidays()throws PageException{
		this.click(ExpediaField.BaliHolidays);
	}

	public void setMenorcaHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.MenorcaHolidays, value);
	}

	public void clickMenorcaHolidays()throws PageException{
		this.click(ExpediaField.MenorcaHolidays);
	}

	public void setRomeHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.RomeHolidays, value);
	}

	public void clickRomeHolidays()throws PageException{
		this.click(ExpediaField.RomeHolidays);
	}

	public void setIbizaHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.IbizaHolidays, value);
	}

	public void clickIbizaHolidays()throws PageException{
		this.click(ExpediaField.IbizaHolidays);
	}

	public void setCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.CarHire, value);
	}

	public void clickCarHire()throws PageException{
		this.click(ExpediaField.CarHire);
	}

	public void setLondonCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.LondonCarHire, value);
	}

	public void clickLondonCarHire()throws PageException{
		this.click(ExpediaField.LondonCarHire);
	}

	public void setOrlandoCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.OrlandoCarHire, value);
	}

	public void clickOrlandoCarHire()throws PageException{
		this.click(ExpediaField.OrlandoCarHire);
	}

	public void setDublinCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.DublinCarHire, value);
	}

	public void clickDublinCarHire()throws PageException{
		this.click(ExpediaField.DublinCarHire);
	}

	public void setEdinburghCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.EdinburghCarHire, value);
	}

	public void clickEdinburghCarHire()throws PageException{
		this.click(ExpediaField.EdinburghCarHire);
	}

	public void setLosAngelesCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.LosAngelesCarHire, value);
	}

	public void clickLosAngelesCarHire()throws PageException{
		this.click(ExpediaField.LosAngelesCarHire);
	}

	public void setBelfastCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.BelfastCarHire, value);
	}

	public void clickBelfastCarHire()throws PageException{
		this.click(ExpediaField.BelfastCarHire);
	}

	public void setFaroCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.FaroCarHire, value);
	}

	public void clickFaroCarHire()throws PageException{
		this.click(ExpediaField.FaroCarHire);
	}

	public void setMalagaCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.MalagaCarHire, value);
	}

	public void clickMalagaCarHire()throws PageException{
		this.click(ExpediaField.MalagaCarHire);
	}

	public void setPalmaDeMallorcaCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.PalmaDeMallorcaCarHire, value);
	}

	public void clickPalmaDeMallorcaCarHire()throws PageException{
		this.click(ExpediaField.PalmaDeMallorcaCarHire);
	}

	public void setManchesterCarHire(final String value) throws PageException{
		this.setValue(ExpediaField.ManchesterCarHire, value);
	}

	public void clickManchesterCarHire()throws PageException{
		this.click(ExpediaField.ManchesterCarHire);
	}

	public void setThingsToDoInBarcelona(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInBarcelona, value);
	}

	public void clickThingsToDoInBarcelona()throws PageException{
		this.click(ExpediaField.ThingsToDoInBarcelona);
	}

	public void setThingsToDoInBerlin(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInBerlin, value);
	}

	public void clickThingsToDoInBerlin()throws PageException{
		this.click(ExpediaField.ThingsToDoInBerlin);
	}

	public void setThingsToDoInVenice(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInVenice, value);
	}

	public void clickThingsToDoInVenice()throws PageException{
		this.click(ExpediaField.ThingsToDoInVenice);
	}

	public void setThingsToDoInLondon(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInLondon, value);
	}

	public void clickThingsToDoInLondon()throws PageException{
		this.click(ExpediaField.ThingsToDoInLondon);
	}

	public void setThingsToDoInDublin(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInDublin, value);
	}

	public void clickThingsToDoInDublin()throws PageException{
		this.click(ExpediaField.ThingsToDoInDublin);
	}

	public void setThingsToDoInLasVegas(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInLasVegas, value);
	}

	public void clickThingsToDoInLasVegas()throws PageException{
		this.click(ExpediaField.ThingsToDoInLasVegas);
	}

	public void setThingsToDoInLosAngeles(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInLosAngeles, value);
	}

	public void clickThingsToDoInLosAngeles()throws PageException{
		this.click(ExpediaField.ThingsToDoInLosAngeles);
	}

	public void setThingsToDoInNewYork(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInNewYork, value);
	}

	public void clickThingsToDoInNewYork()throws PageException{
		this.click(ExpediaField.ThingsToDoInNewYork);
	}

	public void setThingsToDoInParis(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInParis, value);
	}

	public void clickThingsToDoInParis()throws PageException{
		this.click(ExpediaField.ThingsToDoInParis);
	}

	public void setThingsToDoInRome(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInRome, value);
	}

	public void clickThingsToDoInRome()throws PageException{
		this.click(ExpediaField.ThingsToDoInRome);
	}

	public void setThingsToDoInTenerife(final String value) throws PageException{
		this.setValue(ExpediaField.ThingsToDoInTenerife, value);
	}

	public void clickThingsToDoInTenerife()throws PageException{
		this.click(ExpediaField.ThingsToDoInTenerife);
	}

	public void setBeachHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.BeachHolidays, value);
	}

	public void clickBeachHolidays()throws PageException{
		this.click(ExpediaField.BeachHolidays);
	}

	public void setSkiHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.SkiHolidays, value);
	}

	public void clickSkiHolidays()throws PageException{
		this.click(ExpediaField.SkiHolidays);
	}

	public void setDisneylandParisBreaks(final String value) throws PageException{
		this.setValue(ExpediaField.DisneylandParisBreaks, value);
	}

	public void clickDisneylandParisBreaks()throws PageException{
		this.click(ExpediaField.DisneylandParisBreaks);
	}

	public void setPackageHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.PackageHolidays, value);
	}

	public void clickPackageHolidays()throws PageException{
		this.click(ExpediaField.PackageHolidays);
	}

	public void setWhereToGo(final String value) throws PageException{
		this.setValue(ExpediaField.WhereToGo, value);
	}

	public void clickWhereToGo()throws PageException{
		this.click(ExpediaField.WhereToGo);
	}

	public void set72HoursIn(final String value) throws PageException{
		this.setValue(ExpediaField.VALUE_OF_72HoursIn, value);
	}

	public void click72HoursIn()throws PageException{
		this.click(ExpediaField.VALUE_OF_72HoursIn);
	}

	public void setTravelByTrain(final String value) throws PageException{
		this.setValue(ExpediaField.TravelByTrain, value);
	}

	public void clickTravelByTrain()throws PageException{
		this.click(ExpediaField.TravelByTrain);
	}

	public void setHotelDeals(final String value) throws PageException{
		this.setValue(ExpediaField.HotelDeals, value);
	}

	public void clickHotelDeals()throws PageException{
		this.click(ExpediaField.HotelDeals);
	}

	public void setAllInclusiveHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.AllInclusiveHolidays, value);
	}

	public void clickAllInclusiveHolidays()throws PageException{
		this.click(ExpediaField.AllInclusiveHolidays);
	}

	public void setFlightDeals(final String value) throws PageException{
		this.setValue(ExpediaField.FlightDeals, value);
	}

	public void clickFlightDeals()throws PageException{
		this.click(ExpediaField.FlightDeals);
	}

	public void setBlog(final String value) throws PageException{
		this.setValue(ExpediaField.Blog, value);
	}

	public void clickBlog()throws PageException{
		this.click(ExpediaField.Blog);
	}

	public void setTheHotelEdit(final String value) throws PageException{
		this.setValue(ExpediaField.TheHotelEdit, value);
	}

	public void clickTheHotelEdit()throws PageException{
		this.click(ExpediaField.TheHotelEdit);
	}

	public void setLGBTHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.LGBTHolidays, value);
	}

	public void clickLGBTHolidays()throws PageException{
		this.click(ExpediaField.LGBTHolidays);
	}

	public void setCastleHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.CastleHolidays, value);
	}

	public void clickCastleHolidays()throws PageException{
		this.click(ExpediaField.CastleHolidays);
	}

	public void setFamilyHolidays(final String value) throws PageException{
		this.setValue(ExpediaField.FamilyHolidays, value);
	}

	public void clickFamilyHolidays()throws PageException{
		this.click(ExpediaField.FamilyHolidays);
	}

	public void setAccommodation(final String value) throws PageException{
		this.setValue(ExpediaField.Accommodation, value);
	}

	public void clickAccommodation()throws PageException{
		this.click(ExpediaField.Accommodation);
	}

	public void setAboutUs(final String value) throws PageException{
		this.setValue(ExpediaField.AboutUs, value);
	}

	public void clickAboutUs()throws PageException{
		this.click(ExpediaField.AboutUs);
	}

	public void setAdvertising(final String value) throws PageException{
		this.setValue(ExpediaField.Advertising, value);
	}

	public void clickAdvertising()throws PageException{
		this.click(ExpediaField.Advertising);
	}

	public void setNewsroom(final String value) throws PageException{
		this.setValue(ExpediaField.Newsroom, value);
	}

	public void clickNewsroom()throws PageException{
		this.click(ExpediaField.Newsroom);
	}

	public void setJobs(final String value) throws PageException{
		this.setValue(ExpediaField.Jobs, value);
	}

	public void clickJobs()throws PageException{
		this.click(ExpediaField.Jobs);
	}

	public void setPrivacyPolicy(final String value) throws PageException{
		this.setValue(ExpediaField.PrivacyPolicy, value);
	}

	public void clickPrivacyPolicy()throws PageException{
		this.click(ExpediaField.PrivacyPolicy);
	}

	public void setCookiePolicy(final String value) throws PageException{
		this.setValue(ExpediaField.CookiePolicy, value);
	}

	public void clickCookiePolicy()throws PageException{
		this.click(ExpediaField.CookiePolicy);
	}

	public void setTermsOfUse(final String value) throws PageException{
		this.setValue(ExpediaField.TermsOfUse, value);
	}

	public void clickTermsOfUse()throws PageException{
		this.click(ExpediaField.TermsOfUse);
	}

	public void setGeneralTermsAndConditions(final String value) throws PageException{
		this.setValue(ExpediaField.GeneralTermsAndConditions, value);
	}

	public void clickGeneralTermsAndConditions()throws PageException{
		this.click(ExpediaField.GeneralTermsAndConditions);
	}

	public void setMSAStatement(final String value) throws PageException{
		this.setValue(ExpediaField.MSAStatement, value);
	}

	public void clickMSAStatement()throws PageException{
		this.click(ExpediaField.MSAStatement);
	}

	public void setSiteMap(final String value) throws PageException{
		this.setValue(ExpediaField.SiteMap, value);
	}

	public void clickSiteMap()throws PageException{
		this.click(ExpediaField.SiteMap);
	}

	public void setExpediaPartnerCentral(final String value) throws PageException{
		this.setValue(ExpediaField.ExpediaPartnerCentral, value);
	}

	public void clickExpediaPartnerCentral()throws PageException{
		this.click(ExpediaField.ExpediaPartnerCentral);
	}

	public void setAddAHotel(final String value) throws PageException{
		this.setValue(ExpediaField.AddAHotel, value);
	}

	public void clickAddAHotel()throws PageException{
		this.click(ExpediaField.AddAHotel);
	}

	public void setExpediaPartnerSolutionsAPI(final String value) throws PageException{
		this.setValue(ExpediaField.ExpediaPartnerSolutionsAPI, value);
	}

	public void clickExpediaPartnerSolutionsAPI()throws PageException{
		this.click(ExpediaField.ExpediaPartnerSolutionsAPI);
	}

	public void setAddAnActivity(final String value) throws PageException{
		this.setValue(ExpediaField.AddAnActivity, value);
	}

	public void clickAddAnActivity()throws PageException{
		this.click(ExpediaField.AddAnActivity);
	}

	public void setBecomeAnAffiliate(final String value) throws PageException{
		this.setValue(ExpediaField.BecomeAnAffiliate, value);
	}

	public void clickBecomeAnAffiliate()throws PageException{
		this.click(ExpediaField.BecomeAnAffiliate);
	}

	public void setTravelAgencies(final String value) throws PageException{
		this.setValue(ExpediaField.TravelAgencies, value);
	}

	public void clickTravelAgencies()throws PageException{
		this.click(ExpediaField.TravelAgencies);
	}

	public void setArgentina(final String value) throws PageException{
		this.setValue(ExpediaField.Argentina, value);
	}

	public void clickArgentina()throws PageException{
		this.click(ExpediaField.Argentina);
	}

	public void setAustralia(final String value) throws PageException{
		this.setValue(ExpediaField.Australia, value);
	}

	public void clickAustralia()throws PageException{
		this.click(ExpediaField.Australia);
	}

	public void setAustria(final String value) throws PageException{
		this.setValue(ExpediaField.Austria, value);
	}

	public void clickAustria()throws PageException{
		this.click(ExpediaField.Austria);
	}

	public void setBelgium(final String value) throws PageException{
		this.setValue(ExpediaField.Belgium, value);
	}

	public void clickBelgium()throws PageException{
		this.click(ExpediaField.Belgium);
	}

	public void setBrazil(final String value) throws PageException{
		this.setValue(ExpediaField.Brazil, value);
	}

	public void clickBrazil()throws PageException{
		this.click(ExpediaField.Brazil);
	}

	public void setCanada(final String value) throws PageException{
		this.setValue(ExpediaField.Canada, value);
	}

	public void clickCanada()throws PageException{
		this.click(ExpediaField.Canada);
	}

	public void setChina(final String value) throws PageException{
		this.setValue(ExpediaField.China, value);
	}

	public void clickChina()throws PageException{
		this.click(ExpediaField.China);
	}

	public void setDenmark(final String value) throws PageException{
		this.setValue(ExpediaField.Denmark, value);
	}

	public void clickDenmark()throws PageException{
		this.click(ExpediaField.Denmark);
	}

	public void setFinland(final String value) throws PageException{
		this.setValue(ExpediaField.Finland, value);
	}

	public void clickFinland()throws PageException{
		this.click(ExpediaField.Finland);
	}

	public void setFlagChile(final String value) throws PageException{
		this.setValue(ExpediaField.FlagChile, value);
	}

	public void clickFlagChile()throws PageException{
		this.click(ExpediaField.FlagChile);
	}

	public void setFlagColombia(final String value) throws PageException{
		this.setValue(ExpediaField.FlagColombia, value);
	}

	public void clickFlagColombia()throws PageException{
		this.click(ExpediaField.FlagColombia);
	}

	public void setFlagCostaRica(final String value) throws PageException{
		this.setValue(ExpediaField.FlagCostaRica, value);
	}

	public void clickFlagCostaRica()throws PageException{
		this.click(ExpediaField.FlagCostaRica);
	}

	public void setFlagEgypt(final String value) throws PageException{
		this.setValue(ExpediaField.FlagEgypt, value);
	}

	public void clickFlagEgypt()throws PageException{
		this.click(ExpediaField.FlagEgypt);
	}

	public void setFlagEuroCatchAll(final String value) throws PageException{
		this.setValue(ExpediaField.FlagEuroCatchAll, value);
	}

	public void clickFlagEuroCatchAll()throws PageException{
		this.click(ExpediaField.FlagEuroCatchAll);
	}

	public void setFlagPeru(final String value) throws PageException{
		this.setValue(ExpediaField.FlagPeru, value);
	}

	public void clickFlagPeru()throws PageException{
		this.click(ExpediaField.FlagPeru);
	}

	public void setFlagSaudiArabia(final String value) throws PageException{
		this.setValue(ExpediaField.FlagSaudiArabia, value);
	}

	public void clickFlagSaudiArabia()throws PageException{
		this.click(ExpediaField.FlagSaudiArabia);
	}

	public void setFlagUAE(final String value) throws PageException{
		this.setValue(ExpediaField.FlagUAE, value);
	}

	public void clickFlagUAE()throws PageException{
		this.click(ExpediaField.FlagUAE);
	}

	public void setFrance(final String value) throws PageException{
		this.setValue(ExpediaField.France, value);
	}

	public void clickFrance()throws PageException{
		this.click(ExpediaField.France);
	}

	public void setGermany(final String value) throws PageException{
		this.setValue(ExpediaField.Germany, value);
	}

	public void clickGermany()throws PageException{
		this.click(ExpediaField.Germany);
	}

	public void setHongKong(final String value) throws PageException{
		this.setValue(ExpediaField.HongKong, value);
	}

	public void clickHongKong()throws PageException{
		this.click(ExpediaField.HongKong);
	}

	public void setIndia(final String value) throws PageException{
		this.setValue(ExpediaField.India, value);
	}

	public void clickIndia()throws PageException{
		this.click(ExpediaField.India);
	}

	public void setIndonesia(final String value) throws PageException{
		this.setValue(ExpediaField.Indonesia, value);
	}

	public void clickIndonesia()throws PageException{
		this.click(ExpediaField.Indonesia);
	}

	public void setIreland(final String value) throws PageException{
		this.setValue(ExpediaField.Ireland, value);
	}

	public void clickIreland()throws PageException{
		this.click(ExpediaField.Ireland);
	}

	public void setItaly(final String value) throws PageException{
		this.setValue(ExpediaField.Italy, value);
	}

	public void clickItaly()throws PageException{
		this.click(ExpediaField.Italy);
	}

	public void setJapan(final String value) throws PageException{
		this.setValue(ExpediaField.Japan, value);
	}

	public void clickJapan()throws PageException{
		this.click(ExpediaField.Japan);
	}

	public void setKorea(final String value) throws PageException{
		this.setValue(ExpediaField.Korea, value);
	}

	public void clickKorea()throws PageException{
		this.click(ExpediaField.Korea);
	}

	public void setMalaysia(final String value) throws PageException{
		this.setValue(ExpediaField.Malaysia, value);
	}

	public void clickMalaysia()throws PageException{
		this.click(ExpediaField.Malaysia);
	}

	public void setMexico(final String value) throws PageException{
		this.setValue(ExpediaField.Mexico, value);
	}

	public void clickMexico()throws PageException{
		this.click(ExpediaField.Mexico);
	}

	public void setNetherlands(final String value) throws PageException{
		this.setValue(ExpediaField.Netherlands, value);
	}

	public void clickNetherlands()throws PageException{
		this.click(ExpediaField.Netherlands);
	}

	public void setNewZealand(final String value) throws PageException{
		this.setValue(ExpediaField.NewZealand, value);
	}

	public void clickNewZealand()throws PageException{
		this.click(ExpediaField.NewZealand);
	}

	public void setNorway(final String value) throws PageException{
		this.setValue(ExpediaField.Norway, value);
	}

	public void clickNorway()throws PageException{
		this.click(ExpediaField.Norway);
	}

	public void setPhilippines(final String value) throws PageException{
		this.setValue(ExpediaField.Philippines, value);
	}

	public void clickPhilippines()throws PageException{
		this.click(ExpediaField.Philippines);
	}

	public void setSingapore(final String value) throws PageException{
		this.setValue(ExpediaField.Singapore, value);
	}

	public void clickSingapore()throws PageException{
		this.click(ExpediaField.Singapore);
	}

	public void setSpain(final String value) throws PageException{
		this.setValue(ExpediaField.Spain, value);
	}

	public void clickSpain()throws PageException{
		this.click(ExpediaField.Spain);
	}

	public void setSweden(final String value) throws PageException{
		this.setValue(ExpediaField.Sweden, value);
	}

	public void clickSweden()throws PageException{
		this.click(ExpediaField.Sweden);
	}

	public void setSwitzerland(final String value) throws PageException{
		this.setValue(ExpediaField.Switzerland, value);
	}

	public void clickSwitzerland()throws PageException{
		this.click(ExpediaField.Switzerland);
	}

	public void setTaiwan(final String value) throws PageException{
		this.setValue(ExpediaField.Taiwan, value);
	}

	public void clickTaiwan()throws PageException{
		this.click(ExpediaField.Taiwan);
	}

	public void setThailand(final String value) throws PageException{
		this.setValue(ExpediaField.Thailand, value);
	}

	public void clickThailand()throws PageException{
		this.click(ExpediaField.Thailand);
	}

	public void setUnitedKingdom(final String value) throws PageException{
		this.setValue(ExpediaField.UnitedKingdom, value);
	}

	public void clickUnitedKingdom()throws PageException{
		this.click(ExpediaField.UnitedKingdom);
	}

	public void setUnitedStates(final String value) throws PageException{
		this.setValue(ExpediaField.UnitedStates, value);
	}

	public void clickUnitedStates()throws PageException{
		this.click(ExpediaField.UnitedStates);
	}

	public void setVietnam(final String value) throws PageException{
		this.setValue(ExpediaField.Vietnam, value);
	}

	public void clickVietnam()throws PageException{
		this.click(ExpediaField.Vietnam);
	}

	public void setExpediaPartnerSolutionsEPS(final String value) throws PageException{
		this.setValue(ExpediaField.ExpediaPartnerSolutionsEPS, value);
	}

	public void clickExpediaPartnerSolutionsEPS()throws PageException{
		this.click(ExpediaField.ExpediaPartnerSolutionsEPS);
	}

	public void setHotelsCom(final String value) throws PageException{
		this.setValue(ExpediaField.HotelsCom, value);
	}

	public void clickHotelsCom()throws PageException{
		this.click(ExpediaField.HotelsCom);
	}

	public void setEgenciaBusinessTravel(final String value) throws PageException{
		this.setValue(ExpediaField.EgenciaBusinessTravel, value);
	}

	public void clickEgenciaBusinessTravel()throws PageException{
		this.click(ExpediaField.EgenciaBusinessTravel);
	}

	public void setTrivago(final String value) throws PageException{
		this.setValue(ExpediaField.Trivago, value);
	}

	public void clickTrivago()throws PageException{
		this.click(ExpediaField.Trivago);
	}

	public void setHomeAway(final String value) throws PageException{
		this.setValue(ExpediaField.HomeAway, value);
	}

	public void clickHomeAway()throws PageException{
		this.click(ExpediaField.HomeAway);
	}

	public void setTrover(final String value) throws PageException{
		this.setValue(ExpediaField.Trover, value);
	}

	public void clickTrover()throws PageException{
		this.click(ExpediaField.Trover);
	}

	public void setWwwCaaCoUk(final String value) throws PageException{
		this.setValue(ExpediaField.WwwCaaCoUk, value);
	}

	public void clickWwwCaaCoUk()throws PageException{
		this.click(ExpediaField.WwwCaaCoUk);
	}

	public void setWwwFsaGovUkRegister(final String value) throws PageException{
		this.setValue(ExpediaField.WwwFsaGovUkRegister, value);
	}

	public void clickWwwFsaGovUkRegister()throws PageException{
		this.click(ExpediaField.WwwFsaGovUkRegister);
	}

	public void setExpediaInc(final String value) throws PageException{
		this.setValue(ExpediaField.ExpediaInc, value);
	}

	public void clickExpediaInc()throws PageException{
		this.click(ExpediaField.ExpediaInc);
	}

	public void setGcMadBannerLink(final String value) throws PageException{
		this.setValue(ExpediaField.GcMadBannerLink, value);
	}

	public void clickGcMadBannerLink()throws PageException{
		this.click(ExpediaField.GcMadBannerLink);
	}

	public void setHeaderLogo(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderLogo, value);
	}

	public void clickHeaderLogo()throws PageException{
		this.click(ExpediaField.HeaderLogo);
	}

	public void setHeaderHistorySm(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderHistorySm, value);
	}

	public void clickHeaderHistorySm()throws PageException{
		this.click(ExpediaField.HeaderHistorySm);
	}

	public void setHeaderAccountSignup(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountSignup, value);
	}

	public void clickHeaderAccountSignup()throws PageException{
		this.click(ExpediaField.HeaderAccountSignup);
	}

	public void setAccountMenuMyaccount(final String value) throws PageException{
		this.setValue(ExpediaField.AccountMenuMyaccount, value);
	}

	public void clickAccountMenuMyaccount()throws PageException{
		this.click(ExpediaField.AccountMenuMyaccount);
	}

	public void setAccountMenuItineraries(final String value) throws PageException{
		this.setValue(ExpediaField.AccountMenuItineraries, value);
	}

	public void clickAccountMenuItineraries()throws PageException{
		this.click(ExpediaField.AccountMenuItineraries);
	}

	public void setAccountMenuRewards(final String value) throws PageException{
		this.setValue(ExpediaField.AccountMenuRewards, value);
	}

	public void clickAccountMenuRewards()throws PageException{
		this.click(ExpediaField.AccountMenuRewards);
	}

	public void setAccountMenuSignout(final String value) throws PageException{
		this.setValue(ExpediaField.AccountMenuSignout, value);
	}

	public void clickAccountMenuSignout()throws PageException{
		this.click(ExpediaField.AccountMenuSignout);
	}

	public void setSubMenuHeaderShopHome(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopHome, value);
	}

	public void clickSubMenuHeaderShopHome()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopHome);
	}

	public void setSubMenuHeaderShopHotel(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopHotel, value);
	}

	public void clickSubMenuHeaderShopHotel()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopHotel);
	}

	public void setSubMenuHeaderShopFlight(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopFlight, value);
	}

	public void clickSubMenuHeaderShopFlight()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopFlight);
	}

	public void setSubMenuHeaderShopPackage(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopPackage, value);
	}

	public void clickSubMenuHeaderShopPackage()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopPackage);
	}

	public void setSubMenuHeaderShopCar(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopCar, value);
	}

	public void clickSubMenuHeaderShopCar()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopCar);
	}

	public void setSubMenuHeaderShopRail(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopRail, value);
	}

	public void clickSubMenuHeaderShopRail()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopRail);
	}

	public void setSubMenuHeaderShopVacationRental(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopVacationRental, value);
	}

	public void clickSubMenuHeaderShopVacationRental()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopVacationRental);
	}

	public void setSubMenuHeaderShopActivity(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopActivity, value);
	}

	public void clickSubMenuHeaderShopActivity()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopActivity);
	}

	public void setSubMenuHeaderShopLastminute(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopLastminute, value);
	}

	public void clickSubMenuHeaderShopLastminute()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopLastminute);
	}

	public void setSubMenuHeaderShopBeach(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopBeach, value);
	}

	public void clickSubMenuHeaderShopBeach()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopBeach);
	}

	public void setSubMenuHeaderShopDeals(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopDeals, value);
	}

	public void clickSubMenuHeaderShopDeals()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopDeals);
	}

	public void setSubMenuHeaderShopCitybreaks(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopCitybreaks, value);
	}

	public void clickSubMenuHeaderShopCitybreaks()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopCitybreaks);
	}

	public void setSubMenuHeaderShopRewards(final String value) throws PageException{
		this.setValue(ExpediaField.SubMenuHeaderShopRewards, value);
	}

	public void clickSubMenuHeaderShopRewards()throws PageException{
		this.click(ExpediaField.SubMenuHeaderShopRewards);
	}

	public void setHeaderAccountSignin(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountSignin, value);
	}

	public void clickHeaderAccountSignin()throws PageException{
		this.click(ExpediaField.HeaderAccountSignin);
	}

	public void setHeaderAccountRegister(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountRegister, value);
	}

	public void clickHeaderAccountRegister()throws PageException{
		this.click(ExpediaField.HeaderAccountRegister);
	}

	public void setAccountMyaccount(final String value) throws PageException{
		this.setValue(ExpediaField.AccountMyaccount, value);
	}

	public void clickAccountMyaccount()throws PageException{
		this.click(ExpediaField.AccountMyaccount);
	}

	public void setAccountSignout(final String value) throws PageException{
		this.setValue(ExpediaField.AccountSignout, value);
	}

	public void clickAccountSignout()throws PageException{
		this.click(ExpediaField.AccountSignout);
	}

	public void setIdentifiedAccountSignout(final String value) throws PageException{
		this.setValue(ExpediaField.IdentifiedAccountSignout, value);
	}

	public void clickIdentifiedAccountSignout()throws PageException{
		this.click(ExpediaField.IdentifiedAccountSignout);
	}

	public void setIdentifiedAccountSignoutV2(final String value) throws PageException{
		this.setValue(ExpediaField.IdentifiedAccountSignoutV2, value);
	}

	public void clickIdentifiedAccountSignoutV2()throws PageException{
		this.click(ExpediaField.IdentifiedAccountSignoutV2);
	}

	public void setHeaderHistory(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderHistory, value);
	}

	public void clickHeaderHistory()throws PageException{
		this.click(ExpediaField.HeaderHistory);
	}

	public void setTravellertoolsTrip(final String value) throws PageException{
		this.setValue(ExpediaField.TravellertoolsTrip, value);
	}

	public void clickTravellertoolsTrip()throws PageException{
		this.click(ExpediaField.TravellertoolsTrip);
	}

	public void setCheckinTrip(final String value) throws PageException{
		this.setValue(ExpediaField.CheckinTrip, value);
	}

	public void clickCheckinTrip()throws PageException{
		this.click(ExpediaField.CheckinTrip);
	}

	public void setManagemyhotelTrip(final String value) throws PageException{
		this.setValue(ExpediaField.ManagemyhotelTrip, value);
	}

	public void clickManagemyhotelTrip()throws PageException{
		this.click(ExpediaField.ManagemyhotelTrip);
	}

	public void setVisaTrip(final String value) throws PageException{
		this.setValue(ExpediaField.VisaTrip, value);
	}

	public void clickVisaTrip()throws PageException{
		this.click(ExpediaField.VisaTrip);
	}

	public void setSupportCs(final String value) throws PageException{
		this.setValue(ExpediaField.SupportCs, value);
	}

	public void clickSupportCs()throws PageException{
		this.click(ExpediaField.SupportCs);
	}

	public void setSupportFeedback(final String value) throws PageException{
		this.setValue(ExpediaField.SupportFeedback, value);
	}

	public void clickSupportFeedback()throws PageException{
		this.click(ExpediaField.SupportFeedback);
	}

	public void setPrimaryHeaderHome(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderHome, value);
	}

	public void clickPrimaryHeaderHome()throws PageException{
		this.click(ExpediaField.PrimaryHeaderHome);
	}

	public void setPrimaryHeaderHotel(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderHotel, value);
	}

	public void clickPrimaryHeaderHotel()throws PageException{
		this.click(ExpediaField.PrimaryHeaderHotel);
	}

	public void setPrimaryHeaderFlight(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderFlight, value);
	}

	public void clickPrimaryHeaderFlight()throws PageException{
		this.click(ExpediaField.PrimaryHeaderFlight);
	}

	public void setPrimaryHeaderPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderPackage, value);
	}

	public void clickPrimaryHeaderPackage()throws PageException{
		this.click(ExpediaField.PrimaryHeaderPackage);
	}

	public void setPrimaryHeaderCar(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderCar, value);
	}

	public void clickPrimaryHeaderCar()throws PageException{
		this.click(ExpediaField.PrimaryHeaderCar);
	}

	public void setPrimaryHeaderRail(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderRail, value);
	}

	public void clickPrimaryHeaderRail()throws PageException{
		this.click(ExpediaField.PrimaryHeaderRail);
	}

	public void setPrimaryHeaderVacationRental(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderVacationRental, value);
	}

	public void clickPrimaryHeaderVacationRental()throws PageException{
		this.click(ExpediaField.PrimaryHeaderVacationRental);
	}

	public void setPrimaryHeaderActivity(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderActivity, value);
	}

	public void clickPrimaryHeaderActivity()throws PageException{
		this.click(ExpediaField.PrimaryHeaderActivity);
	}

	public void setPrimaryHeaderLastminute(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderLastminute, value);
	}

	public void clickPrimaryHeaderLastminute()throws PageException{
		this.click(ExpediaField.PrimaryHeaderLastminute);
	}

	public void setPrimaryHeaderBeach(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderBeach, value);
	}

	public void clickPrimaryHeaderBeach()throws PageException{
		this.click(ExpediaField.PrimaryHeaderBeach);
	}

	public void setPrimaryHeaderDeals(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderDeals, value);
	}

	public void clickPrimaryHeaderDeals()throws PageException{
		this.click(ExpediaField.PrimaryHeaderDeals);
	}

	public void setPrimaryHeaderCitybreaks(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderCitybreaks, value);
	}

	public void clickPrimaryHeaderCitybreaks()throws PageException{
		this.click(ExpediaField.PrimaryHeaderCitybreaks);
	}

	public void setPrimaryHeaderRewards(final String value) throws PageException{
		this.setValue(ExpediaField.PrimaryHeaderRewards, value);
	}

	public void clickPrimaryHeaderRewards()throws PageException{
		this.click(ExpediaField.PrimaryHeaderRewards);
	}

	public void setAllInHeaderShopMenu(final String value) throws PageException{
		this.setValue(ExpediaField.AllInHeaderShopMenu, value);
	}

	public void clickAllInHeaderShopMenu()throws PageException{
		this.click(ExpediaField.AllInHeaderShopMenu);
	}

	public void setHeaderAccountLastminuteMoreMenu(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountLastminuteMoreMenu, value);
	}

	public void clickHeaderAccountLastminuteMoreMenu()throws PageException{
		this.click(ExpediaField.HeaderAccountLastminuteMoreMenu);
	}

	public void setHeaderAccountBeachMoreMenu(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountBeachMoreMenu, value);
	}

	public void clickHeaderAccountBeachMoreMenu()throws PageException{
		this.click(ExpediaField.HeaderAccountBeachMoreMenu);
	}

	public void setHeaderAccountDealsMoreMenu(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountDealsMoreMenu, value);
	}

	public void clickHeaderAccountDealsMoreMenu()throws PageException{
		this.click(ExpediaField.HeaderAccountDealsMoreMenu);
	}

	public void setHeaderAccountCitybreaksMoreMenu(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountCitybreaksMoreMenu, value);
	}

	public void clickHeaderAccountCitybreaksMoreMenu()throws PageException{
		this.click(ExpediaField.HeaderAccountCitybreaksMoreMenu);
	}

	public void setHeaderAccountRewardsMoreMenu(final String value) throws PageException{
		this.setValue(ExpediaField.HeaderAccountRewardsMoreMenu, value);
	}

	public void clickHeaderAccountRewardsMoreMenu()throws PageException{
		this.click(ExpediaField.HeaderAccountRewardsMoreMenu);
	}

	public void setGssGoToForgotPassword(final String value) throws PageException{
		this.setValue(ExpediaField.GssGoToForgotPassword, value);
	}

	public void clickGssGoToForgotPassword()throws PageException{
		this.click(ExpediaField.GssGoToForgotPassword);
	}

	public void setAddFlightLegHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.AddFlightLegHpFlight, value);
	}

	public void clickAddFlightLegHpFlight()throws PageException{
		this.click(ExpediaField.AddFlightLegHpFlight);
	}

	public void setFlightChildrenHelpHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.FlightChildrenHelpHpFlight, value);
	}

	public void clickFlightChildrenHelpHpFlight()throws PageException{
		this.click(ExpediaField.FlightChildrenHelpHpFlight);
	}

	public void setFlightAdvancedOptionsHpFlight(final String value) throws PageException{
		this.setValue(ExpediaField.FlightAdvancedOptionsHpFlight, value);
	}

	public void clickFlightAdvancedOptionsHpFlight()throws PageException{
		this.click(ExpediaField.FlightAdvancedOptionsHpFlight);
	}

	public void setDriverAgeHelpDefault(final String value) throws PageException{
		this.setValue(ExpediaField.DriverAgeHelpDefault, value);
	}

	public void clickDriverAgeHelpDefault()throws PageException{
		this.click(ExpediaField.DriverAgeHelpDefault);
	}

	public void setHotelAddFlightHpHotel(final String value) throws PageException{
		this.setValue(ExpediaField.HotelAddFlightHpHotel, value);
	}

	public void clickHotelAddFlightHpHotel()throws PageException{
		this.click(ExpediaField.HotelAddFlightHpHotel);
	}

	public void setHotelAddCarHpHotel(final String value) throws PageException{
		this.setValue(ExpediaField.HotelAddCarHpHotel, value);
	}

	public void clickHotelAddCarHpHotel()throws PageException{
		this.click(ExpediaField.HotelAddCarHpHotel);
	}

	public void setHotelFlightChildrenHelpHpHotel(final String value) throws PageException{
		this.setValue(ExpediaField.HotelFlightChildrenHelpHpHotel, value);
	}

	public void clickHotelFlightChildrenHelpHpHotel()throws PageException{
		this.click(ExpediaField.HotelFlightChildrenHelpHpHotel);
	}

	public void setPackageAdvancedOptionsHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageAdvancedOptionsHpPackage, value);
	}

	public void clickPackageAdvancedOptionsHpPackage()throws PageException{
		this.click(ExpediaField.PackageAdvancedOptionsHpPackage);
	}

	public void setPackageFlightChildrenHelpHpPackage(final String value) throws PageException{
		this.setValue(ExpediaField.PackageFlightChildrenHelpHpPackage, value);
	}

	public void clickPackageFlightChildrenHelpHpPackage()throws PageException{
		this.click(ExpediaField.PackageFlightChildrenHelpHpPackage);
	}

	public void setAddRailCardHpRail(final String value) throws PageException{
		this.setValue(ExpediaField.AddRailCardHpRail, value);
	}

	public void clickAddRailCardHpRail()throws PageException{
		this.click(ExpediaField.AddRailCardHpRail);
	}

	public void setFeefoContainer(final String value) throws PageException{
		this.setValue(ExpediaField.FeefoContainer, value);
	}

	public void clickFeefoContainer()throws PageException{
		this.click(ExpediaField.FeefoContainer);
	}

	public void setReasonsToBelieveContainer(final String value) throws PageException{
		this.setValue(ExpediaField.ReasonsToBelieveContainer, value);
	}

	public void clickReasonsToBelieveContainer()throws PageException{
		this.click(ExpediaField.ReasonsToBelieveContainer);
	}

	public void setRvContainer(final String value) throws PageException{
		this.setValue(ExpediaField.RvContainer, value);
	}

	public void clickRvContainer()throws PageException{
		this.click(ExpediaField.RvContainer);
	}

	public void setTopdestContainer(final String value) throws PageException{
		this.setValue(ExpediaField.TopdestContainer, value);
	}

	public void clickTopdestContainer()throws PageException{
		this.click(ExpediaField.TopdestContainer);
	}

	public void setAddHotelLink(final String value) throws PageException{
		this.setValue(ExpediaField.AddHotelLink, value);
	}

	public void clickAddHotelLink()throws PageException{
		this.click(ExpediaField.AddHotelLink);
	}

}
