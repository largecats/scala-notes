package main.scala

trait Test[+A] {
  def name: String
  def perform[B >: A](pilot: Pilot[B], mission: Mission[B]): Record[B]
}

//class GenericTest(val name: String) extends Test[Task] {
//  def perform[Task](pilot: GenericPilot, mission: GenericMission) = {
//    GenericRecord(pilot.name, mission)
//  }
//}
