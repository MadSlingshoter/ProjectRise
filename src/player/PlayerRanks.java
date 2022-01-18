package player;


/** 
 * Enum class used to deal with the players rank. That is, different things happen
 * when the same method is called for different ranks
 * 
 * @author AevanDino
 */

public enum PlayerRanks {
	
	/**
	 * Player rank peasant
	 */
	PEASANT {
		/**
		 * How salary is calculated for peasants
		 */
		public int getSalary(int dots) {
			return 20 * dots;
		}
		
		/**
		 * Highest level a property can be
		 */
		public int nbrOfLevels() {
			return 1;
		}

		/**
		 * Tax for peasants
		 */
		public int calculateTax() {
			return 200; 
		}
	},
	
	/**
	 * Player rank knight
	 */
	KNIGHT {
		
		/**
		 * How salary is calculated for knights
		 */
		public int getSalary(int dots) {
			return 25 * dots;
		}

		/**
		 * Highest level a property can be
		 */
		public int nbrOfLevels() {
			return 3;
		}

		/**
		 * Tax for Knights
		 */
		public int calculateTax() {
			return 200;
		}
	},
	
	/**
	 * Player rank lord
	 */
	LORD {
		/**
		 * How salary is calculated for Lords
		 */
		public int getSalary(int dots) {
			return 30 * dots;
		}
		
		/**
		 * Highest level a property can be
		 */
		public int nbrOfLevels() {
			return 5;
		}
		
		/**
		 * Tax for Lords
		 */
		public int calculateTax() {
			return 200;
		}
	},
	
	
	KINGS {
		
		/**
		 * How salary is calculated for the king
		 */
		public int getSalary(int dots) {
		
			return 40 * dots;
			
		}

		/**
		 * Highest level a property can be
		 */
		public int nbrOfLevels() {
			return 5;
		}

		/**
		 * Tax for rulers
		 */
		public int calculateTax() {
			return 0;
		}
	};

	public abstract int getSalary(int dots);
	public abstract int nbrOfLevels();
	public abstract int calculateTax();
	
	
}
