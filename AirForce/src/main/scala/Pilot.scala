package main.scala

trait Pilot[-A] {
  val name: String
  val capability: Int
  def fly(aircraft: A): Unit
}

class GenericPilot(val name: String, val capability: Int) extends Pilot[Aircraft] {
  def fly(aircraft: Aircraft): Unit = {
    println(s"${this.name}: I'm a ${this.getClass.getSimpleName}, and I'm flying a ${aircraft.name} ${aircraft.getClass.getSimpleName}")
  }
}

class CombatPilot(val name: String, val capability: Int) extends Pilot[CombatAircraft] {
  def fly(aircraft: CombatAircraft): Unit = {
    println(s"${this.name}: I'm a ${this.getClass.getSimpleName}, and I'm flying a ${aircraft.name} ${aircraft.getClass.getSimpleName}")
  }
}

class FighterPilot(val name: String, val capability: Int) extends Pilot[FighterAircraft] {
  def fly(aircraft: FighterAircraft): Unit = {
    println(s"${this.name}: I'm a ${this.getClass.getSimpleName}, and I'm flying a ${aircraft.name} ${aircraft.getClass.getSimpleName}")
  }
}

object Pilot {
  def print_pilot_profile[A](pilot: Pilot[A]): Unit = {
    println(s"${pilot.name}: ${pilot.getClass.getSimpleName} with capability ${pilot.capability}")
  }

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