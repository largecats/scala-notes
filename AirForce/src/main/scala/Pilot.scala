package main.scala

trait Pilot[-A] { // contravariant in A
  def fly(aircraft: A): Unit
}

class GenericPilot() extends Pilot[Aircraft] {
  def fly(aircraft: Aircraft): Unit = {
    println(s"I'm a ${this.getClass.getSimpleName}, and I'm flying a ${aircraft.name} ${aircraft.getClass.getSimpleName}")
  }
}

class CombatPilot() extends Pilot[CombatAircraft] {
  def fly(aircraft: CombatAircraft): Unit = {
    println(s"I'm a ${this.getClass.getSimpleName}, and I'm flying a ${aircraft.name} ${aircraft.getClass.getSimpleName}")
  }
}

class FighterPilot() extends Pilot[FighterAircraft] {
  def fly(aircraft: FighterAircraft): Unit = {
    println(s"I'm a ${this.getClass.getSimpleName}, and I'm flying a ${aircraft.name} ${aircraft.getClass.getSimpleName}")
  }
}

object Pilot {
  def fly_generic(pilot: Pilot[Aircraft], aircraft: Aircraft): Unit = {
    pilot.fly(aircraft)
  }

  def fly_combat(pilot: Pilot[CombatAircraft], aircraft: CombatAircraft): Unit = {
    pilot.fly(aircraft)
  }

  def fly_fighter(pilot: Pilot[FighterAircraft], aircraft: FighterAircraft): Unit = {
    pilot.fly(aircraft)
  }
}