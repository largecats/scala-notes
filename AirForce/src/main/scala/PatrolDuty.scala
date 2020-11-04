package main.scala

class PatrolDuty[A](aircraft: A) { // PatrolDuty is invariant in A
  var aircraftOnPatrolDuty: A = aircraft // mutable, should be invariant
  def print_flight_log(): Unit = println(s"A ${aircraft.getClass.getSimpleName} is on duty today")
}