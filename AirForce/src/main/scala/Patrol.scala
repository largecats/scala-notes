package main.scala

class Patrol[A](aircraft: A) { // invariant in A
  var aircraftOnPatrol: A = aircraft // mutable, should be invariant
  def print_flight_log(): Unit = println(s"A ${aircraft.getClass.getSimpleName} is on duty today")
}