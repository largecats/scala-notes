package main.scala

trait FlightSchool[A] {
  def course: List[Mission[A]]
  def pilot: Pilot[A]

  def takeCourse: List[String] = course.map(pilot.perform)
}

case class GenericFlightSchool(course: List[Mission[Task]], pilot: Pilot[Task]) extends FlightSchool[Task]
case class MilitaryFlightSchool(course: List[Mission[MilitaryTask]], pilot: Pilot[MilitaryTask]) extends FlightSchool[MilitaryTask]
case class CivilianFlightSchool(course: List[Mission[CivilianTask]], pilot: Pilot[CivilianTask]) extends FlightSchool[CivilianTask]

case class AirToAirStrikeFlightSchool(course: List[Mission[AirToAirStrike]], pilot: Pilot[AirToAirStrike]) extends FlightSchool[AirToAirStrike]